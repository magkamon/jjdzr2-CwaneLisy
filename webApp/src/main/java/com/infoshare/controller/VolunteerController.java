package com.infoshare.controller;

import com.infoshare.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("volunteer")
public class VolunteerController {

    private final VolunteerService volunteerService;

    @Autowired
    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @GetMapping("/create")
    public String createVolunteer(Model model) {
        getMessage(model);
        return "test-view";
    }

    @GetMapping("/search")
    public String searchForVolunteer(Model model) {
        getMessage(model);
        return "test-view";
    }

    @GetMapping("/edit")
    public String editVolunteer(Model model) {
        getMessage(model);
        return "test-view";
    }

    @GetMapping("/changeStatus")
    public String changeVolunteerStatus(Model model) {
        getMessage(model);
        return "test-view";
    }
    
    private Model getMessage(Model model) {
        return model.addAttribute("message", "This page is under construction...");
    }
}
