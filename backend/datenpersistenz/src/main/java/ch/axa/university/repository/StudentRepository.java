package ch.axa.university.repository;

import ch.axa.university.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
