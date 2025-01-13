package org.example.get.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.example.get.Class.Ans;
import org.example.get.Class.Item;
import org.example.get.Service.GetService;
import org.example.get.mapper.AnsMapper;
import org.example.get.Service.AnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class AnsServiceImpl extends MppServiceImpl<AnsMapper, Ans> implements AnsService {
    private final ItemServiceImpl itemServiceImpl;
    private final GetServiceImpl getServiceImpl;
    @Autowired
    public AnsServiceImpl(ItemServiceImpl itemServiceImpl, GetServiceImpl getServiceImpl) {
        this.itemServiceImpl = itemServiceImpl;
        this.getServiceImpl = getServiceImpl;
    }
    @Override
    public List<List<Ans>> ansByItems(Collection<Item> items) {
        List<List<Ans>> ansLists = new ArrayList<>();
        for (Item item : items) {
            LambdaQueryWrapper<Ans> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Ans::getItemId, item.getItemId());
            List<Ans> list = list(wrapper);
            if (!list.isEmpty()) {
                ansLists.add(list);
            }
        }
           return ansLists;
    }

    @Override
    public String get(int getId,String userId, String userName) {

       Collection<Item> items= itemServiceImpl.itemByGetId(getId);
       int total = 0;
       for (Item item : items) {
           total += item.getNum() - item.getTake();
       }
       if(total==0)
       {
           getServiceImpl.over(getId);
           return null;
       }
       else {
           Random random = new Random();
           int num = random.nextInt(total)+1;
           String back = "";
           for (Item item : items) {
               if (num <= item.getNum() - item.getTake()) {
                   LambdaQueryWrapper<Ans> wrapper = new LambdaQueryWrapper<>();
                   wrapper.eq(Ans::getGetId,getId).eq(Ans::getUserId,userId);
                   List<Ans> list = list(wrapper);
                   if(!list.isEmpty())
                   {
                       return "";
                   }
                   Ans ans = new Ans();
                   ans.setItemId(item.getItemId());
                   ans.setUserId(userId);
                   ans.setGetId(getId);
                   ans.setUserName(userName);
                   save(ans);
                   item.setTake(item.getTake() + 1);
                   itemServiceImpl.updateByMultiId(item);
                   if(total==1)
                       getServiceImpl.over(getId);
                   back = item.getItemName();
                   break;
               } else
                   num -= item.getNum() - item.getTake();
           }
           return back;
       }
    }
}
