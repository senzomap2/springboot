package com.senzo.investments.service;

import com.senzo.investments.model.entity.InvestorDetails;
import com.senzo.investments.model.entity.InvestorProduct;
import com.senzo.investments.model.entity.Product;
import com.senzo.investments.repository.InvestorProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestorProductService {
    @Autowired
    InvestorProductRepo investorProductRepo;

    public InvestorProduct findByProductId(int productId, int investorId){
        return investorProductRepo.findByProductAndInvestorDetails(new Product(productId),new InvestorDetails(investorId));
    }
}
