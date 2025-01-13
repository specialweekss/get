package org.example.get.Service;

import com.github.jeffreyning.mybatisplus.service.IMppService;
import org.example.get.Class.Item;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ItemService extends IMppService<Item> {
    public Collection<Item> itemByGetId(int getId);
    public Item itemByItemId(int itemId);
}
