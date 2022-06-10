package ch.axa.university.controller;

import ch.axa.university.model.Student;
import ch.axa.university.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"${app.security.cors.origin}"})
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Iterable<Student>> getStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Student getStudentById(@Validated @PathVariable int id) {
        return studentService.getStudentById(id);
    }
}
