package ch.axa.university.repository;

import ch.axa.university.model.Modul;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface ModulRepository extends CrudRepository<Modul, Integer> {
}