package com.springboot.transactionmanagement.service;

import com.springboot.transactionmanagement.model.CandidateModel;
import com.springboot.transactionmanagement.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
//@Transactional
public class CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    public CandidateModel saveCandidate(CandidateModel model) {
        CandidateModel candidateModel = candidateRepository.save(model);
        try {
            int a = 12 / 0;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return candidateModel;
    }
}
