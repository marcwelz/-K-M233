package ch.axa.university.repository;

import ch.axa.university.model.Faculty;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {

}