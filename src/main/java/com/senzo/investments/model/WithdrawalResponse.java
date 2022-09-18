package com.senzo.investments.model;

import com.senzo.investments.model.entity.Withdrawal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
@ApiModel(value = "WithdrawalResponse")
public class WithdrawalResponse {
    @ApiModelProperty(name = "message", notes = "response message", example = "successfully processed withdrawal")
    private String message;
    @ApiModelProperty(name = "statusCode", notes = "HTTP status response code", example = "200")
    private int statusCode;
    @ApiModelProperty(name = "withdrawal", notes = "displays withdrawal details")
    private Withdrawal withdrawal;
    @ApiModelProperty(name = "errors", notes = "list of errors (if any)",
            example = "[{errorCode:1401,errorMessage:'amount exceeds balance'}]")
    private List<String> errorList;
}
