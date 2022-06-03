package ch.axa.university.repository;

import ch.axa.university.model.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends CrudRepository<Faculty, Integer> {
}
