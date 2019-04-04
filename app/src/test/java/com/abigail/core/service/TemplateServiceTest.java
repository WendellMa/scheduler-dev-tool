package com.abigail.core.service;

import com.abigail.core.domain.bo.template.TimerTaskTemplate;
import com.abigail.core.service.template.impl.TemplateServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TemplateServiceTest {
  @Autowired
  TemplateServiceImpl templateService;

  @Test
  public void getTemplateList(){
    templateService.getTemplateList("test",0, 0);

  }

  @Test
  public void addTemplate(){
    List<TimerTaskTemplate> list = new ArrayList<>();
    TimerTaskTemplate timerTaskTemplate = new TimerTaskTemplate();
    timerTaskTemplate.setTemplateId(1234567890);
    timerTaskTemplate.setTemplateName("test1");
    list.add(timerTaskTemplate);
    templateService.addTemplate(list);
  }
}
