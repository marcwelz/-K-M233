package ch.axa.university.controller;

import ch.axa.university.model.Modul;
import ch.axa.university.model.Student;
import ch.axa.university.service.ModulesService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@CrossOrigin(origins = {"${app.security.cors.origin}"})
@AllArgsConstructor
@RequestMapping("/modules")
public class ModulesController {

    private final ModulesService service;

    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Iterable<Modul> getModules() {
        return service.getAllModules();
    }
}
