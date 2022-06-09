package com.springboot.transactionmanagement.controller;

import com.springboot.transactionmanagement.model.CandidateModel;
import com.springboot.transactionmanagement.model.Konto;
import com.springboot.transactionmanagement.model.TranscationalModel;
import com.springboot.transactionmanagement.service.CandidateService;
import com.springboot.transactionmanagement.service.KontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/konto")
public class KontoController {

    @Autowired
    KontoService kontoService;

    @PostMapping("/")
    public Konto saveKonto(@RequestBody Konto model) {
        Konto saveModel = kontoService.saveKonto(model);
        return saveModel;
    }

    @GetMapping("/account")
    public List<Konto> getAllAccounts(){
        return kontoService.getAllAccounts();
    }

    @GetMapping("/balance")
    public int getSaldi(){
        return kontoService.getAllSaldi();
    }

    @GetMapping("/transaction")
    public void transaction(@RequestBody TranscationalModel model){
        kontoService.moveMoney(model);
    }
}