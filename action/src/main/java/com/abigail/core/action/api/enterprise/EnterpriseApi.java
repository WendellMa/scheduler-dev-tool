package com.abigail.core.action.api.enterprise;

import com.abigail.core.domain.bo.enterprise.EnterpriseInfo;
import com.abigail.core.domain.co.ErrorResponseResult;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(
        value = "enterprise",
        description = "企业操作接口",
        tags = {"enterprise"}
)
@RequestMapping(value = "/action/enterprise",produces = "application/json")
public interface EnterpriseApi {
    @ApiOperation(
            nickname = "listEnterprise",
            httpMethod = "GET",
            value = "获取企业列表",
            notes = "获取企业列表",
            tags = {"enterprise"}
//            ,
//            extensions = {
//                    @Extension(name = "x-ups-permissionName", properties = {
//                            @ExtensionProperty(value = "", name = "")
//                    })
//
//            }
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponseResult.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponseResult.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ErrorResponseResult.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorResponseResult.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseResult.class)
    })
    @GetMapping()
    ResponseEntity<List<EnterpriseInfo>> listEnterprise();
}
