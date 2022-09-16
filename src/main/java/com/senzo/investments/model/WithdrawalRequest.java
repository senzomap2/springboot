package com.senzo.investments.model;

import com.senzo.investments.model.entity.InvestorProduct;
import com.senzo.investments.model.entity.StatusLog;
import com.senzo.investments.model.entity.Withdrawal;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "WithdrawalRequest", description = "Incoming HTTP request for withdrawal")
public class WithdrawalRequest {
    private String idNumber;
    private String investorName;
    private String investorSurname;
    private String contactNumber;
    private String emailAddress;
    private String productType;
    private BigDecimal amount;
    private String bankName;
    private String accountNumber;
    private String accountType;

}
