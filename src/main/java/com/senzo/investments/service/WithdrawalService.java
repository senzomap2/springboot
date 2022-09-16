package com.senzo.investments.service;

import com.senzo.investments.enums.ProductEnum;
import com.senzo.investments.model.WError;
import com.senzo.investments.model.WithdrawalRequest;
import com.senzo.investments.model.WithdrawalResponse;
import com.senzo.investments.model.entity.InvestorDetails;
import com.senzo.investments.model.entity.InvestorProduct;
import com.senzo.investments.model.entity.Withdrawal;
import com.senzo.investments.repository.WithdrawalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WithdrawalService {
    @Autowired
    private InvestorService investorService;
    @Autowired
    private InvestorProductService investorProductService;

    @Autowired
    WithdrawalRepo withdrawalRepo;
    /**
     * Processes withdrawal request and validates:
     * - If PRODUCT is RETIREMENT, then the investor's age must be greater than 65
     * - If WITHDRAWAL AMOUNT is greater than current BALANCE
     * - If investor tries to withdraw an AMOUNT more than 90% of the current BALANCE
     * Returns Withdrawal response object
     * @param withdrawalRequest
     * @return
     */
    public WithdrawalResponse processWithdrawal(WithdrawalRequest withdrawalRequest) {
        WithdrawalResponse response = new WithdrawalResponse();
        String productType=withdrawalRequest.getProductType();
        String idNumber = withdrawalRequest.getIdNumber();
        InvestorDetails investor = investorService.getInvestorByIdNumber(idNumber);
        ProductEnum productEnum = ProductEnum.valueOf(productType);
        InvestorProduct investorProduct = investorProductService.findByProductId(productEnum.getProduct(),
                investor.getInvestorId());

        List<String> errors = new ArrayList<>();
        BigDecimal amount = withdrawalRequest.getAmount();
        BigDecimal currentBalance = investorProduct.getCurrentbalance();
        if(investor==null){
            response.setMessage("Failed to withdraw");
            response.setStatusCode(406);
            errors.add(WError.WE_1404);
        }else{
            LocalDate currentDate = LocalDate.now();
            Date dob = investor.getDob();
            LocalDate localDob = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            long age = localDob.until(currentDate, ChronoUnit.YEARS);
            if(productEnum==ProductEnum.RETIREMENT && age<65){
                errors.add(WError.WE_1401);
            }
            if(amount.compareTo(currentBalance)>0){
                errors.add(WError.WE_1402);
            }
            if(amount.compareTo(currentBalance.multiply(new BigDecimal("0.9")))>0){
                errors.add(WError.WE_1403);
            }
            if(errors.isEmpty()){
                Withdrawal withdrawal = new Withdrawal();
                BigDecimal closingBalance = currentBalance.subtract(amount);
                withdrawal.setWithdrawalAmount(amount);
                withdrawal.setClosingBalance(closingBalance);
                withdrawal.setOpeningBalance(currentBalance);
                withdrawal.setInvestorProduct(investorProduct);
                withdrawalRepo.save(withdrawal);
                response.setStatusCode(200);
                response.setMessage("Successfully captured withdrawal for "+
                        investor.getInvestorName()+" "+investor.getSurname()+"\n"+
                        "opening balance: "+currentBalance+"\namount withdrawn: "+amount+"\n"+
                        "closing balance: "+closingBalance);
            }
        }
        response.setErrorList(errors);
        return response;
    }
}
