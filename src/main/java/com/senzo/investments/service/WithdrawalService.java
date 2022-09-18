package com.senzo.investments.service;

import com.senzo.investments.enums.ProductEnum;
import com.senzo.investments.model.WError;
import com.senzo.investments.model.WithdrawalRequest;
import com.senzo.investments.model.WithdrawalResponse;
import com.senzo.investments.model.entity.BankDetails;
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
        ProductEnum productType=withdrawalRequest.getProductType();
        String idNumber = withdrawalRequest.getIdNumber();
        InvestorDetails investor = investorService.getInvestorByIdNumber(idNumber);
        List<String> errors = new ArrayList<>();
        if(investor==null){
            response.setMessage("Your id number does not exist in out system");
            response.setStatusCode(401);
            errors.add(WError.WE_1404);
        }else{
            InvestorProduct investorProduct = investorProductService.findByProductId(productType.getProduct(),
                    investor.getInvestorId());
            BigDecimal amount = withdrawalRequest.getAmount();
            BigDecimal currentBalance = investorProduct.getCurrentbalance();
            String errorMessage = "Validation Failed!";
            LocalDate currentDate = LocalDate.now();
            LocalDate dob = investor.getDob();
            long age = dob.until(currentDate, ChronoUnit.YEARS);
            if(productType==ProductEnum.RETIREMENT && age<65){
                errors.add(WError.WE_1401);
                response.setStatusCode(412);
                response.setMessage(errorMessage);
            }
            if(amount.compareTo(currentBalance)>0){
                errors.add(WError.WE_1402);
                response.setStatusCode(412);
                response.setMessage(errorMessage);
            }
            if(amount.compareTo(currentBalance.multiply(new BigDecimal("0.9")))>0){
                errors.add(WError.WE_1403);
                response.setStatusCode(412);
                response.setMessage(errorMessage);
            }
            if(errors.isEmpty()){
                Withdrawal withdrawal = new Withdrawal();
                BigDecimal closingBalance = currentBalance.subtract(amount);
                withdrawal.setWithdrawalAmount(amount);
                withdrawal.setClosingBalance(closingBalance);
                withdrawal.setOpeningBalance(currentBalance);
                withdrawal.setInvestorProduct(investorProduct);
                withdrawal.setWithdrawalTime(new Date());
                BankDetails bankDetails = new BankDetails();
                bankDetails.setBankName(withdrawalRequest.getBankName());
                bankDetails.setAccountNumber(withdrawalRequest.getAccountNumber());
                bankDetails.setInvestorDetails(investor);
                investorService.saveBankDetails(bankDetails);
                Withdrawal savedWithdrawal = withdrawalRepo.save(withdrawal);
                response.setWithdrawal(savedWithdrawal);
                investorProduct.setCurrentbalance(closingBalance);
                investorProductService.save(investorProduct);
                response.setStatusCode(200);
                response.setMessage("Successfully captured withdrawal for "+
                        investor.getInvestorName()+" "+investor.getSurname()+" of age: "+age+"\n"+
                        "opening balance: "+currentBalance+"\namount withdrawn: "+amount+"\n"+
                        "closing balance: "+closingBalance);
            }
        }
        response.setErrorList(errors);
        return response;
    }

    public void deleteAll(){
        withdrawalRepo.deleteAll();
    }

    public Iterable<Withdrawal> findAll(){
        return withdrawalRepo.findAll();
    }
}
