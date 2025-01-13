package org.example.get.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.get.Class.TheGet;
import org.example.get.Service.GetService;
import org.example.get.mapper.GetMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GetServiceImpl extends ServiceImpl<GetMapper, TheGet>  implements GetService {
    @Override
    public Collection<TheGet> getByUserId(String userId) {
        LambdaQueryWrapper<TheGet> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TheGet::getUserId, userId);
        return this.list(queryWrapper);
    }

    @Override
    public void over(int getId) {
        TheGet get = getById(getId);
        get.setState(1);
        updateById(get);
    }
}
