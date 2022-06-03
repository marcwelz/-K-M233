package ch.axa.university.service;

import ch.axa.university.model.Faculty;
import ch.axa.university.model.Modul;
import ch.axa.university.repository.EnrollmentRepository;
import ch.axa.university.repository.ModulRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnrollmentSerivce {

    private final EnrollmentRepository repository;

    public Iterable<Faculty> getAllEnrollments() {
        return repository.findAll();
    }
}
