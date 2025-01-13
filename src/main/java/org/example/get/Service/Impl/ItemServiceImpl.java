package org.example.get.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.example.get.Class.Item;
import org.example.get.Service.ItemService;
import org.example.get.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ItemServiceImpl extends MppServiceImpl<ItemMapper, Item> implements ItemService {
    @Override
    public Collection<Item> itemByGetId(int getId) {
        LambdaQueryWrapper<Item> queryWrapper = new LambdaQueryWrapper<Item>();
        queryWrapper.eq(Item::getGetId, getId);
        return list(queryWrapper);
    }

    @Override
    public Item itemByItemId(int itemId) {
        LambdaQueryWrapper<Item> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Item::getItemId, itemId);
        return list(queryWrapper).get(0);
    }
}
