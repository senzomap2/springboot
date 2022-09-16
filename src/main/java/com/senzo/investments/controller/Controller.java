package com.senzo.investments.controller;

import com.senzo.investments.model.entity.InvestorDetails;
import com.senzo.investments.model.WithdrawalRequest;
import com.senzo.investments.model.WithdrawalResponse;
import com.senzo.investments.service.InvestorService;
import com.senzo.investments.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/withdrawals")
public class Controller {

    @Autowired
    InvestorService investorService;
    @Autowired
    WithdrawalService withdrawalService;

    @GetMapping("/investors")
    public List<InvestorDetails> investorDetailsList(){
        return investorService.getAllInvestors();
    }

    @PostMapping(path = "/withdraw")
    public ResponseEntity<WithdrawalResponse> withdraw(@Valid @RequestBody WithdrawalRequest withdrawalRequest){
            WithdrawalResponse withdrawalResponse=withdrawalService.processWithdrawal(withdrawalRequest);
            return ResponseEntity.ok().body(withdrawalResponse);
    }
}
