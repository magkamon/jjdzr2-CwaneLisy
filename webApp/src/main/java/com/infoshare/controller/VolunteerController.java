package com.infoshare.controller;

import com.infoshare.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VolunteerController {

    private final VolunteerService volunteerService;

    @Autowired
    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;

    }

    @GetMapping("/createVolunteer")
    public String createVolunteer(Model model) {
        return "";
    }

    @GetMapping("/searchForVolunteer")
    public String searchForVolunteer(Model model) {
        return "";
    }

    @GetMapping("/editVolunteer")
    public String editVolunteer(Model model) {
        return "";
    }

    @GetMapping("/changeVolunteerStatus")
    public String changeVolunteerStatus(Model model) {
        return "";
    }
}
