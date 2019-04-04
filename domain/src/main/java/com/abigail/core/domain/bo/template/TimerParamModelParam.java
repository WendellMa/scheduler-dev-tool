package com.abigail.core.domain.bo.template;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class TimerParamModelParam {

  int id;
  short ifDefault;
  int keyId;
  String valueName;
  int valueId;
  Date createdAt;
  Date updatedAt;
}
