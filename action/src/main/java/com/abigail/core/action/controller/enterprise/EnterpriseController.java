package com.abigail.core.action.controller.enterprise;

import com.abigail.core.action.api.enterprise.EnterpriseApi;
import com.abigail.core.domain.bo.enterprise.EnterpriseInfo;
import com.abigail.core.domain.co.ErrorResponseResult;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EnterpriseController implements EnterpriseApi {

    @Override
    public ResponseEntity<List<EnterpriseInfo>> listEnterprise() {
        List<EnterpriseInfo> enterpriseInfos = new ArrayList<>();
        return new ResponseEntity<>(enterpriseInfos,HttpStatus.OK);
    }
}
