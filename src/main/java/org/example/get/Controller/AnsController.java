package org.example.get.Controller;

import org.apache.ibatis.annotations.Param;
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

import java.util.List;

@RestController
public class AnsController {

    private  final AnsServiceImpl ansService;
    private final GetServiceImpl getService;
    private final ItemServiceImpl itemService;
    @Autowired
    public  AnsController(AnsServiceImpl ans, GetServiceImpl getService, ItemServiceImpl itemService){
        this.ansService = ans;
        this.getService = getService;
        this.itemService = itemService;

    }
    @PostMapping("/get")
    public Result get(int getId,String userId,String userName){
        String itemName= ansService.get(getId,userId,userName);
        if(itemName == null){
            return Result.fail(0,"抽签结束");
        }
        else  if(itemName.isEmpty()){
            return Result.fail(-1,"重复抽签");
        }
        else
            return Result.success(itemName);
    }

}
