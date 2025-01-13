package org.example.get.Class;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class TheGet {
    @TableId(type = IdType.AUTO)
    int getId;
    String userId;
    String title;
    int state;
}
