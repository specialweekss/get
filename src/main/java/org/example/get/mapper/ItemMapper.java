package org.example.get.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.get.Class.Item;

@Mapper
public interface ItemMapper extends MppBaseMapper<Item> {

}
