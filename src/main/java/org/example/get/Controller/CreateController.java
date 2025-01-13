package org.example.get.Controller;

import org.example.get.Class.Item;
import org.example.get.Class.TheGet;
import org.example.get.Format.Result;
import org.example.get.Service.Impl.GetServiceImpl;
import org.example.get.Service.Impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CreateController {
    private final GetServiceImpl getServiceImpl;
    private final ItemServiceImpl itemServiceImpl;
    @Autowired
    public CreateController(GetServiceImpl getServiceImpl, ItemServiceImpl itemServiceImpl) {
        this.getServiceImpl = getServiceImpl;
        this.itemServiceImpl = itemServiceImpl;
    }
    @PostMapping("/getCommit")
    public Result getCommit(@RequestBody TheGet get) {
        if(getServiceImpl.save(get)) {
            return Result.success(get.getGetId());
        }
        else
            return Result.fail();
    }
    @PostMapping("/itemCommit")
    public Result itemCommit(@RequestBody Collection<Item> item_list) {
        if(itemServiceImpl.saveBatch(item_list))
            return Result.success(item_list);
        else
            return Result.fail();
    }
}
