package org.example.get.Class;

import com.baomidou.mybatisplus.annotation.TableId;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;

@Data
public class Ans {
    @MppMultiId
    int itemId;
    @MppMultiId
    String userId;
    @MppMultiId
    int getId;
    String userName;
}
