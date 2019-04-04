package com.abigail.core.service.template;

import com.abigail.core.domain.bo.template.TimerTaskTemplate;

import java.util.List;

public interface TemplateService {
  public List<TimerTaskTemplate> getTemplateList(String templateName,int templateId, int ifDeleted);
  public int addTemplate(List<TimerTaskTemplate> list);
}
