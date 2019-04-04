package com.abigail.core.domain.bo.template;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class TimerTaskTemplate {
  int id;
  int ifDeleted;
  Date deletedAt;
  int templateId;
  String templateName;
  Date createdAt;
  Date updatedAt;
}
