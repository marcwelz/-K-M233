package com.springboot.transactionmanagement.repository;

import com.springboot.transactionmanagement.model.CandidateModel;
import com.springboot.transactionmanagement.model.Konto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KontoRepository extends JpaRepository<Konto, Integer> {

}
