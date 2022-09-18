package com.senzo.investments.service;

import com.senzo.investments.model.entity.InvestorDetails;
import com.senzo.investments.model.entity.InvestorProduct;
import com.senzo.investments.model.entity.Product;
import com.senzo.investments.repository.InvestorProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorProductService {
    @Autowired
    InvestorProductRepo investorProductRepo;

    public InvestorProduct findByProductId(int productId, int investorId){
        Product product = new Product();
        product.setProductId(productId);
        InvestorDetails investorDetails = new InvestorDetails();
        investorDetails.setInvestorId(investorId);
        return investorProductRepo.findByProductAndInvestorDetails(product,investorDetails);
    }

    public void deleteAll(){
        investorProductRepo.deleteAll();
    }
    public InvestorProduct save(InvestorProduct investorProduct){
        return investorProductRepo.save(investorProduct);
    }

    public List<InvestorProduct> findByInvestor(Integer investorId) {
        InvestorDetails investorDetails = new InvestorDetails();
        investorDetails.setInvestorId(investorId);
        return investorProductRepo.findByInvestorDetails(investorDetails);
    }
}
