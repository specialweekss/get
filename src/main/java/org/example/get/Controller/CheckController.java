package org.example.get.Controller;

import org.example.get.Class.Ans;
import org.example.get.Class.Item;
import org.example.get.Class.TheGet;
import org.example.get.Format.Result;
import org.example.get.Service.Impl.AnsServiceImpl;
import org.example.get.Service.Impl.GetServiceImpl;
import org.example.get.Service.Impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class CheckController {
    private final ItemServiceImpl itemServiceImpl;
    private final GetServiceImpl getServiceImpl;
    private final AnsServiceImpl ansServiceImpl;
    @Autowired
    public CheckController(ItemServiceImpl itemServiceImpl, GetServiceImpl getServiceImpl,AnsServiceImpl ansServiceImpl) {
        this.itemServiceImpl = itemServiceImpl;
        this.getServiceImpl = getServiceImpl;
        this.ansServiceImpl = ansServiceImpl;
    }
    @GetMapping("/getByUserId")
    public Result getByUserId(String userId) {
        Collection<TheGet> get_list = getServiceImpl.getByUserId(userId);
        if(!get_list.isEmpty()) {
            return Result.success(get_list,get_list.size());
        }
        else
            return Result.fail();
    }
    @GetMapping("/itemByGetId")
    public Result itemByGetId(int getId) {
        Collection<Item> item_list = itemServiceImpl.itemByGetId(getId);
        if(!item_list.isEmpty()) {
            return Result.success(item_list,item_list.size());
        }
        else
            return Result.fail();
    }
    @PostMapping("/ansByItems")
    public Result getAnsByItems(@RequestBody Collection<Item> items){
        List<List<Ans>> ansLists = ansServiceImpl.ansByItems(items);
        if(!ansLists.isEmpty()){
            return  Result.success(ansLists,ansLists.size());
        }
        else
            return Result.fail();
    }
}
