package com.senzo.investments.repository;

import com.senzo.investments.model.entity.Withdrawal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalRepo extends CrudRepository<Withdrawal, Long> {
}
