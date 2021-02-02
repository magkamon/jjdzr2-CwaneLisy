package com.infoshare.controller;

import com.infoshare.domain.Volunteer;
import com.infoshare.formobjects.VolunteerForm;
import com.infoshare.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        model.addAttribute(new VolunteerForm());
        model.addAttribute("types", volunteerService.getTypesOfHelp());
        return "volunteer-register-form";
    }

    @PostMapping("/form-details")
    public String createVolunteerFormDetails(@Valid @ModelAttribute("volunteerForm") VolunteerForm volunteerFrom, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("types", volunteerService.getTypesOfHelp());
            return "/volunteer-register-form";
        } else {
            volunteerService.registerNewVolunteer(volunteerFrom.getName(), volunteerFrom.getLocation(), volunteerFrom.getEmail(),
                    volunteerFrom.getPhone(), volunteerFrom.getTypeOfHelp(), volunteerFrom.isAvalible());
            return "redirect:/volunteer/all";
        }
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Volunteer> printAllVolunteers() {
        return volunteerService.getAllVolunteers();
    }

    @GetMapping("/search")
    public String searchForVolunteer(Model model) {
        return getTestViewWithPageUnderConstructionMessage(model);
    }

    @GetMapping("/edit")
    public String editVolunteer(Model model) {
        return getTestViewWithPageUnderConstructionMessage(model);
    }

    @GetMapping("/change-status")
    public String changeVolunteerStatus(Model model) {
        return getTestViewWithPageUnderConstructionMessage(model);
    }

    private String getTestViewWithPageUnderConstructionMessage(Model model) {
        model.addAttribute("message", "This page is under construction...");
        return "test-view";
    }
}
