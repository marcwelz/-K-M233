package ch.axa.university.controller;

import ch.axa.university.service.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin()
@AllArgsConstructor
public class JokeController {

    private final UniversityService service;

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "index";
    }

    @GetMapping("/modules")
    public String getModules(Model model) {
        model.addAttribute("modules", service.getAllModules());
        return "modul";
    }
}
