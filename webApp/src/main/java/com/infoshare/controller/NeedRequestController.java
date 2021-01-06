package com.infoshare.controller;

import com.infoshare.service.NeedRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("need-request")
public class NeedRequestController {
    private final NeedRequestService needRequestService;

    @Autowired
    public NeedRequestController(NeedRequestService needRequestService) {
        this.needRequestService = needRequestService;
    }

    @GetMapping("/create")
    public String createNeedRequest(Model model) {
        getMessage(model);
        return "test-view";
    }

    @GetMapping("/search")
    public String searchForNeedRequest(Model model) {
        getMessage(model);
        return "test-view";
    }

    @GetMapping("/edit")
    public String editNeedRequest(Model model) {
        getMessage(model);
        return "test-view";
    }

    @GetMapping("/associateToVolunteer")
    public String associateNeedRequestToVolunteer(Model model) {
        getMessage(model);
        return "test-view";
    }

    @GetMapping("/addComment")
    public String addCommentToNeedRequest(Model model) {
        getMessage(model);
        return "test-view";
    }

    @GetMapping("/browseHistory")
    public String browseHistoryOfNeedRequest(Model model) {
        getMessage(model);
        return "test-view";
    }

    private Model getMessage(Model model) {
        return model.addAttribute("message", "This page is under construction...");
    }
}
