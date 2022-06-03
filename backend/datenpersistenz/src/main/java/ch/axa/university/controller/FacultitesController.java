package ch.axa.university.controller;

import ch.axa.university.repository.FacultyRepository;
import ch.axa.university.service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin()
@AllArgsConstructor
@RequestMapping("/faculty")
public class FacultitesController {

    private final FacultyService service;

    @GetMapping("")
    public String getFaculties(Model model) {
        model.addAttribute("facultities", service.getAllFacultities());
        return "faculty";
    }
}
