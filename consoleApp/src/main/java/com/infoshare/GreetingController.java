package com.infoshare;

import com.infoshare.database.JsonStorage;
import com.infoshare.domain.GlobalLists;
import com.infoshare.persistence.Persistence;
import com.infoshare.persistence.PersistenceImplementation;
import com.infoshare.service.NeedRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        Persistence persistence=new PersistenceImplementation(new JsonStorage(), GlobalLists.INSTANCE
                .getVolunteerMap(),
                GlobalLists.INSTANCE.getNeedRequestMap());

        model.addAttribute("need", persistence.getNeedRequestMap().values());
        return "greeting";
    }

}
