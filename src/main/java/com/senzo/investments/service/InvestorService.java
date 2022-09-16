package com.senzo.investments.service;

import com.senzo.investments.enums.ProductEnum;
import com.senzo.investments.model.WError;
import com.senzo.investments.model.entity.InvestorDetails;
import com.senzo.investments.model.WithdrawalRequest;
import com.senzo.investments.model.WithdrawalResponse;
import com.senzo.investments.model.entity.InvestorProduct;
import com.senzo.investments.model.entity.Product;
import com.senzo.investments.repository.InvestorDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InvestorService {
    @Autowired
    InvestorDetailsRepo investorDetailsRepo;
    @Autowired
    InvestorProductService investorProductService;

    public InvestorDetails getInvestorById(long id) {
        return investorDetailsRepo.findById(id).get();
    }
    public List<InvestorDetails> getAllInvestors(){
        List<InvestorDetails> investors = new ArrayList<InvestorDetails>();
        investorDetailsRepo.findAll().forEach(investor -> investors.add(investor));
        return investors;
    }
    public void saveOrUpdate(InvestorDetails investorDetails) {
        investorDetailsRepo.save(investorDetails);
    }
    public InvestorDetails getInvestorByIdNumber(String idNumber){
        return investorDetailsRepo.findByIdNumber(idNumber);
    }

}
