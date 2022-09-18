package com.senzo.investments.controller;

import com.senzo.investments.model.entity.InvestorDetails;
import com.senzo.investments.model.entity.InvestorProduct;
import com.senzo.investments.service.InvestorProductService;
import com.senzo.investments.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/investor")
public class InvestorController {
    @Autowired
    private InvestorService investorService;
    @Autowired
    private InvestorProductService investorProductService;

    @GetMapping("/details/{investor_id}")
    public ResponseEntity<InvestorDetails> getInvestor(@PathVariable(value = "investor_id") Integer investorId){
        return ResponseEntity.ok().body(investorService.getInvestorById(investorId));
    }

    @GetMapping("/products/{investor_id}")
    public ResponseEntity<List<InvestorProduct>> getInvestorProducts(@PathVariable(value = "investor_id") Integer investorId){
        return ResponseEntity.ok().body(investorProductService.findByInvestor(investorId));
    }
}
