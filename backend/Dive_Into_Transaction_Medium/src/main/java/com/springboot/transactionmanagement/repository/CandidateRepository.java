package com.springboot.transactionmanagement.repository;

import com.springboot.transactionmanagement.model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateModel, String> {
}
