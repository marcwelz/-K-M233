package com.springboot.transactionmanagement.service;

import com.springboot.transactionmanagement.model.CandidateModel;
import com.springboot.transactionmanagement.model.Konto;
import com.springboot.transactionmanagement.model.TranscationalModel;
import com.springboot.transactionmanagement.repository.CandidateRepository;
import com.springboot.transactionmanagement.repository.KontoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class KontoService {

    @Autowired
    private final KontoRepository kontoRepository;

    public Konto saveKonto(Konto model) {
        return kontoRepository.save(model);
    }

    public List<Konto> getAllAccounts(){
        return kontoRepository.findAll();
    }

    public int getAllSaldi(){
        List<Konto> kontoList = kontoRepository.findAll();
        int saldo = 0;
        saldo += kontoList.stream().mapToInt(Konto::getSaldo).sum();

        return saldo;
    }

    public void moveMoney(TranscationalModel model){
        withdraw(model);
        deposit(model);
    }

    private void withdraw(TranscationalModel model) {
        Konto sender = kontoRepository.findById(model.getFromId()).get();
        sender.setSaldo(sender.getSaldo()- model.getAmount());

        kontoRepository.save(sender);
    }

    private void deposit(TranscationalModel model) {
        Konto reciever = kontoRepository.findById(model.getToId()).get();
        reciever.setSaldo(reciever.getSaldo()+ model.getAmount());

        kontoRepository.save(reciever);
    }
}
