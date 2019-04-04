package com.abigail.core.domain.bo.template;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class TimerParamItem {

  int id;
  int itemId;
  String itemKeyName;
  short keyStatus;
  String itemReg;
  int isDeleted;
  Date deletedAt;
  int templateId;
  Date createdAt;
  Date updatedAt;
}
