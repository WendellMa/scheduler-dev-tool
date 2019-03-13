package com.abigail.core.repository.mapper;

import com.abigail.core.domain.dto.CountInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Repository
@Mapper
public interface MemberMapper {
    Long getMemberCount();
}
