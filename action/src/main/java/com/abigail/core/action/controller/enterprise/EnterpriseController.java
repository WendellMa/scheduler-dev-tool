package com.abigail.core.action.controller.enterprise;

import com.abigail.core.action.api.enterprise.EnterpriseApi;
import com.abigail.core.domain.bo.enterprise.EnterpriseInfo;
import com.abigail.core.domain.co.ErrorResponseResult;
import com.abigail.core.service.enterprise.EnterpriseService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@Slf4j
public class EnterpriseController implements EnterpriseApi {
    private EnterpriseService service;

    @Autowired
    public EnterpriseController(EnterpriseService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<EnterpriseInfo>> listEnterprise() {

        List<EnterpriseInfo> list = service.listEnterprise();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
