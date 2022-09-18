package com.senzo.investments.repository;

import com.senzo.investments.model.entity.InvestorDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorDetailsRepo extends CrudRepository<InvestorDetails, Integer> {
    @Query(value = "select i from InvestorDetails i where i.idnumber=:idnumber")
    InvestorDetails findByIdNumber(String idnumber);
}
