package org.example.get.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.jeffreyning.mybatisplus.service.IMppService;
import org.example.get.Class.Ans;
import org.example.get.Class.Item;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface AnsService extends IMppService<Ans> {
    public List<List<Ans>> ansByItems(Collection<Item> items);
    public String get(int getId,String userId ,String userName);
}
