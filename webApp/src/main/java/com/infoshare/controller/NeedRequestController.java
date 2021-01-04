package com.infoshare.controller;

import com.infoshare.service.NeedRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NeedRequestController {
    private final NeedRequestService needRequestService;

    @Autowired
    public NeedRequestController(NeedRequestService needRequestService) {
        this.needRequestService = needRequestService;
    }

    @GetMapping("/createNeedRequest")
    public String createNeedRequest(Model model) {
        return "";
    }

    @GetMapping("/searchForNeedRequest")
    public String searchForNeedRequest(Model model) {
        return "";
    }

    @GetMapping("/editNeedRequest")
    public String editNeedRequest(Model model) {
        return "";
    }

    @GetMapping("/associateNeedRequestToVolunteer")
    public String associateNeedRequestToVolunteer(Model model) {
        return "";
    }

    @GetMapping("/addCommentToNeedRequest")
    public String addCommentToNeedRequest(Model model) {
        return "";
    }

    @GetMapping("/browseHistoryOfNeedRequest")
    public String browseHistoryOfNeedRequest(Model model) {
        return "";
    }
}
