package ch.axa.jokebook.controller;

import ch.axa.jokebook.service.JokeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin()
@AllArgsConstructor
public class JokeController {

    private final JokeService service;

    @GetMapping("/")
    public String getJokes(Model model) {
        model.addAttribute("jokes", service.getJokes());
        return "index";
    }
}
