package ch.axa.university.controller;

import ch.axa.university.service.ModulesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin()
@AllArgsConstructor
@RequestMapping("/modules")
public class ModulesController {

    private final ModulesService service;

    @GetMapping("")
    public String getModules(Model model) {
        model.addAttribute("modules", service.getAllModules());
        return "modul";
    }
}
