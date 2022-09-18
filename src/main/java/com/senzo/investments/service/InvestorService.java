package com.senzo.investments.service;

import com.senzo.investments.model.entity.BankDetails;
import com.senzo.investments.model.entity.InvestorDetails;
import com.senzo.investments.repository.BankDetailsRepo;
import com.senzo.investments.repository.InvestorDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestorService {
    @Autowired
    InvestorDetailsRepo investorDetailsRepo;
    @Autowired
    InvestorProductService investorProductService;
    @Autowired
    BankDetailsRepo bankDetailsRepo;
    public InvestorDetails getInvestorById(Integer id) {
        return investorDetailsRepo.findById(id).get();
    }
    public List<InvestorDetails> getAllInvestors(){
        List<InvestorDetails> investors = new ArrayList<InvestorDetails>();
        Iterable<InvestorDetails> all = investorDetailsRepo.findAll();
        for (InvestorDetails investor:all) {
            investors.add(investor);
        }
        return investors;
    }
    public void save(InvestorDetails investorDetails) {
        investorDetailsRepo.save(investorDetails);
    }
    public InvestorDetails getInvestorByIdNumber(String idNumber){
        return investorDetailsRepo.findByIdNumber(idNumber);
    }

    public void saveBankDetails(BankDetails bankDetails){
        bankDetailsRepo.save(bankDetails);
    }

}
