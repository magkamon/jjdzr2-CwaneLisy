package com.infoshare;

import com.infoshare.service.NeedRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NeedRequestController {
    NeedRequestService needRequestService;

    @Autowired
    public NeedRequestController(NeedRequestService needRequestService) {
        this.needRequestService = needRequestService;
    }

    @GetMapping("/createNeedRequest")
    @ResponseBody
    public String createNeedRequest(Model model) {
        return "";
    }

    @GetMapping("/searchForNeedRequest")
    @ResponseBody
    public String searchForNeedRequest(Model model) {
        return "";
    }

    @GetMapping("/editNeedRequest")
    @ResponseBody
    public String editNeedRequest(Model model) {
        return "";
    }

    @GetMapping("/associateNeedRequestToVolunteer")
    @ResponseBody
    public String associateNeedRequestToVolunteer(Model model) {
        return "";
    }

    @GetMapping("/addCommentToNeedRequest")
    @ResponseBody
    public String addCommentToNeedRequest(Model model) {
        return "";
    }

    @GetMapping("/browseHistoryOfNeedRequest")
    @ResponseBody
    public String browseHistoryOfNeedRequest(Model model) {
        return "";
    }
}
