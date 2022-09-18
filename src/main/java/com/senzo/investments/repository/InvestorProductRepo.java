package com.senzo.investments.repository;

import com.senzo.investments.model.entity.InvestorDetails;
import com.senzo.investments.model.entity.InvestorProduct;
import com.senzo.investments.model.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestorProductRepo extends CrudRepository<InvestorProduct, Long> {
    InvestorProduct findByProductAndInvestorDetails(Product productId, InvestorDetails investorId);

    List<InvestorProduct> findByInvestorDetails(InvestorDetails investorDetails);
}
