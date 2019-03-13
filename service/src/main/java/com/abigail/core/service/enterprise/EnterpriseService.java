package com.abigail.core.service.enterprise;

import com.abigail.core.domain.bo.enterprise.EnterpriseInfo;
import com.abigail.core.repository.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class EnterpriseService {
    private MemberMapper memberMapper;

    @Autowired
    public EnterpriseService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<EnterpriseInfo> listEnterprise() {
        log.info("member count info : {}", memberMapper.getMemberCount());
        return new ArrayList<>();
    }
}
