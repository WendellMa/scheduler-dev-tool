package com.abigail.core.domain.co;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseResult {
    @ApiModelProperty(notes = "错误的信息描述", required = true)
    @JsonProperty(value = "message")
    private String message;

    @ApiModelProperty(notes = "错误码", required = true)
    @JsonProperty(value = "code")
    private int code;
}