package ch.axa.university.controller;

import ch.axa.university.model.Modul;
import ch.axa.university.model.Student;
import ch.axa.university.service.ModulesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = {"${app.security.cors.origin}"})
@AllArgsConstructor
@RequestMapping("/modules")
public class ModulesController {

    private final ModulesService service;

    @GetMapping("/getall")
    public Iterable<Modul> getModules() {
        return service.getAllModules();
    }
}
