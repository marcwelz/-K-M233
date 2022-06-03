package ch.axa.university.controller;

import ch.axa.university.service.EnrollmentSerivce;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin()
@AllArgsConstructor
@RequestMapping("/enrollment")
public class EnrollmentController {

    private final EnrollmentSerivce service;

    @GetMapping("")
    public String getAllEnrollments(Model model) {
        model.addAttribute("enrollments", service.getAllEnrollments());
        return "enrollment";
    }
}
