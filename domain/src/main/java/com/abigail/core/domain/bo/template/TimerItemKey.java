package com.abigail.core.domain.bo.template;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class TimerItemKey {

  int id;
  int keyId;
  String keyName;
  int itemId;
  Date createdAt;
  Date updatedAt;
}
