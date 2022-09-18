package com.senzo.investments.repository;

import com.senzo.investments.model.entity.BankDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailsRepo extends CrudRepository<BankDetails, Long> {
}
