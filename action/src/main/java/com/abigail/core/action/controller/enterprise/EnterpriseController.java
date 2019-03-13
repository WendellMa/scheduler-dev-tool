package com.abigail.core.action.controller.enterprise;

import com.abigail.core.action.api.enterprise.EnterpriseApi;
import com.abigail.core.domain.bo.enterprise.EnterpriseInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EnterpriseController implements EnterpriseApi {

    @Override
    public ResponseEntity<List<EnterpriseInfo>> listEnterprise() {
        List<EnterpriseInfo> enterpriseInfos = new ArrayList<>();
        return new ResponseEntity<>(enterpriseInfos,HttpStatus.OK);
    }
}
