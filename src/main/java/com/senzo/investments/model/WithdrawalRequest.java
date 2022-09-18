package com.senzo.investments.model;

import com.senzo.investments.enums.ProductEnum;
import com.senzo.investments.model.entity.InvestorProduct;
import com.senzo.investments.model.entity.StatusLog;
import com.senzo.investments.model.entity.Withdrawal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@ApiModel(value = "WithdrawalRequest", description = "Incoming HTTP request for withdrawal")
public class WithdrawalRequest {
    @ApiModelProperty(value = "IDNumber", notes = "ID number for investor, must be 13 digits",
            example = "8202125120089", dataType = "long")
    @Size(min=13,max = 13,message = "ID number must 13 digits")
    @Pattern(regexp="^[0-9]+$", message = "ID number must be numeric digits")
    private String idNumber;
    @ApiModelProperty(notes = "name of investor", required = true, example = "John")
    private String investorName;
    @ApiModelProperty(notes = "surname of investor", required = true, example = "Doe")
    private String investorSurname;
    @ApiModelProperty(notes = "contact number of investor", example = "0761236547")
    private String contactNumber;
    @ApiModelProperty(notes = "email address of investor", example = "john@email.com")
    private String emailAddress;
    @ApiModelProperty(notes = "product type of the withdrawal request", required = true, example = "SAVINGS",
            allowableValues = "SAVINGS, RETIREMENT")
    private ProductEnum productType;
    @ApiModelProperty(name = "withdrawalAmount",required = true,notes = "amount to be withdrawn",example = "50250.55")
    private BigDecimal amount;
    @ApiModelProperty(notes = "name of the bank the money should be deposited to", required = true, example = "ABSA")
    private String bankName;
    @ApiModelProperty(notes = "investor's account number belonging to the selected bank", required = true, example = "1234568474")
    private String accountNumber;
    @ApiModelProperty(notes = "bank account type", example = "current")
    private String accountType;
}
