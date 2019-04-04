package com.abigail.core.repository.mapper.repositoryImpl;

import com.abigail.core.domain.bo.template.TimerTaskTemplate;
import com.abigail.core.repository.mapper.TemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TemplateMapperImpl  implements TemplateMapper {

  @Autowired
  TemplateMapper templateMapper;

  @Override
  public List<TimerTaskTemplate> getTemplateList(String templateName, int templateId, int ifDeleted) {
    return  templateMapper.getTemplateList(templateName, templateId, ifDeleted);
  }

  @Override
  public int addTemplate(List<TimerTaskTemplate> list) {
    templateMapper.addTemplate(list);
    return 0;
  }
}
