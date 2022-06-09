package com.springboot.transactionmanagement.controller;

import com.springboot.transactionmanagement.model.CandidateModel;
import com.springboot.transactionmanagement.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/Candidate")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @PostMapping("/")
    public CandidateModel saveCandidate(@RequestBody CandidateModel model) {
        CandidateModel saveModel = candidateService.saveCandidate(model);
        return saveModel;
    }
}
