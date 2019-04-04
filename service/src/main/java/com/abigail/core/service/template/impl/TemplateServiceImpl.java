package com.abigail.core.service.template.impl;

import com.abigail.core.domain.bo.template.TimerTaskTemplate;
import com.abigail.core.repository.mapper.TemplateMapper;
import com.abigail.core.service.template.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {
  @Autowired
  private TemplateMapper templateMapper;


  @Override
  public List<TimerTaskTemplate> getTemplateList(String templateName,int templateId, int ifDeleted) {
    if(!templateName.isEmpty()){
      templateName = '%'+templateName+'%';
    }
    return  templateMapper.getTemplateList(templateName,templateId,ifDeleted );
  }
  @Override
  public int addTemplate(List<TimerTaskTemplate> list){

      templateMapper.addTemplate(list);
      return 0;
  }

}
