package com.abigail.core.repository.mapper;

import com.abigail.core.domain.bo.template.TimerTaskTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface TemplateMapper {
  List<TimerTaskTemplate> getTemplateList( @Param("templateName") String templateName,@Param("templateId") int templateId, @Param("ifDeleted") int ifDeleted);
  int addTemplate(@Param("list") List<TimerTaskTemplate> list);
}
