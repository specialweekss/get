package org.example.get.Class;

import com.baomidou.mybatisplus.annotation.TableId;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;

@Data
public class Item {
  @MppMultiId
  int itemId;
  @MppMultiId
  String getId;
  String itemName;
  int Num;
  int take;
}
