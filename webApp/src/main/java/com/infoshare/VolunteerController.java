package com.infoshare;

import com.infoshare.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VolunteerController {

    VolunteerService volunteerService;

    @Autowired
    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;

    }

    @GetMapping("/createVolunteer")
    @ResponseBody
    public String createVolunteer(Model model) {
        return "";
    }

    @GetMapping("/searchForVolunteer")
    @ResponseBody
    public String searchForVolunteer(Model model) {
        return "";
    }

    @GetMapping("/editVolunteer")
    @ResponseBody
    public String editVolunteer(Model model) {
        return "";
    }

    @GetMapping("/changeVolunteerStatus")
    @ResponseBody
    public String changeVolunteerStatus(Model model) {
        return "";
    }
}
