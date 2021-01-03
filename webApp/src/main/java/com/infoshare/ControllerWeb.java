package com.infoshare;

import com.infoshare.domain.TypeOfHelp;
import com.infoshare.domain.Volunteer;
import com.infoshare.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ControllerWeb {

    VolunteerService volunteerService;

    @Autowired
    public ControllerWeb(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @GetMapping("/volunteers")
    @ResponseBody
    public String getVolunteersFromCityWalkingTheDog(@RequestParam String city) {
        List<Volunteer> volunteerList = volunteerService.getVolunteerFilteredList(city, TypeOfHelp.WALKING_THE_DOG);
        return volunteerList.toString();
    }
}
