package ch.axa.university.service;

import ch.axa.university.model.Modul;
import ch.axa.university.repository.ModulRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModulesService {

    private final ModulRepository repository;

    public Iterable<Modul> getAllModules(){
        return repository.findAll();
    }
}
