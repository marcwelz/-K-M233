package ch.axa.university.controller;

import ch.axa.university.model.Faculty;
import ch.axa.university.model.Student;
import ch.axa.university.repository.FacultyRepository;
import ch.axa.university.service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = {"${app.security.cors.origin}"})
@AllArgsConstructor
@RequestMapping("/faculty")
public class FacultitesController {

    private final FacultyService service;

    @GetMapping("/getall")
    public Iterable<Faculty> getFaculaties() {
        return service.getAllFacultities();
    }

    @GetMapping("/get={id}")
    public Faculty getFacultyById(@PathVariable String id) {
        return service.getFacultyById(id);
    }
}
