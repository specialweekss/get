package org.example.get.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.get.Class.TheGet;

@Mapper
public interface GetMapper extends BaseMapper<TheGet> {
}
