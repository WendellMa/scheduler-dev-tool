package com.abigail.core.action.api.enterprise;

import com.abigail.core.domain.bo.enterprise.EnterpriseInfo;
import com.abigail.core.domain.co.ErrorResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Api(
        value = "enterprise",
        description = "企业操作接口"
)
public interface EnterpriseApi {
    @ApiOperation(
            value = "获取企业列表",
            notes = "获取企业列表",
            tags = {"enterprise"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponseResult.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponseResult.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ErrorResponseResult.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorResponseResult.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseResult.class)
    })
    @GetMapping(value = "/action/enterprise",produces = {"application/json"})
    ResponseEntity<List<EnterpriseInfo>> listEnterprise();
}
