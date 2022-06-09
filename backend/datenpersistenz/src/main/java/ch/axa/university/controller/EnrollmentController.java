package ch.axa.university.controller;

import ch.axa.university.model.Enrollment;
import ch.axa.university.model.Faculty;
import ch.axa.university.model.Student;
import ch.axa.university.service.EnrollmentSerivce;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.  Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = {"${app.security.cors.origin}"})
@AllArgsConstructor
@RequestMapping("/enrollment")
public class EnrollmentController {

    private final EnrollmentSerivce service;

    @GetMapping("/getall")
    public Iterable<Faculty> getEnrollment() {
        return service.getAllEnrollments();
    }
}
