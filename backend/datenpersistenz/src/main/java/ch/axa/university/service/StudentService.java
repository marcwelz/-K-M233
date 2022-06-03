package ch.axa.university.service;

import ch.axa.university.model.Student;
import ch.axa.university.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Iterable<Student> getAllStudents(){
        return repository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return repository.findById(id);
    }

}