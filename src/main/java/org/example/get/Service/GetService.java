package org.example.get.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.get.Class.Item;
import org.example.get.Class.TheGet;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface GetService extends IService<TheGet> {
    public Collection<TheGet> getByUserId(String userId);
    public void over(int getId);
}
