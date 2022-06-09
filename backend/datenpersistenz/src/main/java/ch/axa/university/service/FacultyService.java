package ch.axa.university.service;

import ch.axa.university.model.Faculty;
import ch.axa.university.repository.FacultyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FacultyService {

    private final FacultyRepository repository;

    public Iterable<Faculty> getAllFacultities() {
        return repository.findAll();
    }

    public Faculty getFacultyById(String id) {
        Optional<Faculty> faculty = repository.findById(Integer.parseInt(id));
        return faculty.isEmpty() ? null : faculty.get();
    }
}
