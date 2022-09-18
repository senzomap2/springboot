package com.senzo.investments.controller;

import com.senzo.investments.model.entity.InvestorDetails;
import com.senzo.investments.model.WithdrawalRequest;
import com.senzo.investments.model.WithdrawalResponse;
import com.senzo.investments.model.entity.Withdrawal;
import com.senzo.investments.service.InvestorService;
import com.senzo.investments.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/withdrawals")
public class WithdrawalController {

    @Autowired
    InvestorService investorService;
    @Autowired
    WithdrawalService withdrawalService;

    @GetMapping(path = "/all")
    public Iterable<Withdrawal> allWithdrawals(){
        return withdrawalService.findAll();
    }
    @PostMapping(path = "/withdraw")
    public ResponseEntity<WithdrawalResponse> withdraw(@Valid @RequestBody WithdrawalRequest withdrawalRequest){
            WithdrawalResponse withdrawalResponse=withdrawalService.processWithdrawal(withdrawalRequest);
            return ResponseEntity.status(withdrawalResponse.getStatusCode()).body(withdrawalResponse);
//            return ResponseEntity.ok().body(withdrawalResponse);
    }
}
