package ch.axa.university.service;

import ch.axa.university.model.Faculty;
import ch.axa.university.model.Modul;
import ch.axa.university.model.Student;
import ch.axa.university.repository.FacultyRepository;
import ch.axa.university.repository.ModulRepository;
import ch.axa.university.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UniversityService {

    private final StudentRepository studentRepository;
    private final ModulRepository modulRepository;
    private final FacultyRepository facultyRepository;

    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Iterable<Modul> getAllModules(){
        return modulRepository.findAll();
    }

    public Iterable<Faculty> getAllFaculties(){
        return facultyRepository.findAll();
    }


}
