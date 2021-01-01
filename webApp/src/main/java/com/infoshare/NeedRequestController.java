package com.infoshare;

import com.infoshare.domain.TypeOfHelp;
import com.infoshare.formObjects.NeedRequestForm;
import com.infoshare.service.NeedRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NeedRequestController {
    NeedRequestService needRequestService;

    @Autowired
    public NeedRequestController(NeedRequestService needRequestService) {
        this.needRequestService = needRequestService;
    }

    @GetMapping("/createNeedRequest")
    public String createNeedRequest(Model model) {
        model.addAttribute(new NeedRequestForm());
        List<TypeOfHelp> typeOfHelp = Arrays.asList(TypeOfHelp.values());

        model.addAttribute("types", typeOfHelp);
        return "createNeedRequestForm";
    }

    @PostMapping("/needRequestForm")
    public String createNeedRequestFromForm(@ModelAttribute("needRequestForm") NeedRequestForm needRequestForm) {
        System.out.println(needRequestForm.getName());
        System.out.println(needRequestForm.getLocation());
        System.out.println(needRequestForm.getPhone());
        System.out.println(needRequestForm.getTypeOfHelp());
        needRequestService.createNeedRequest(needRequestForm.getName(), needRequestForm.getLocation(), needRequestForm.getPhone(), needRequestForm.getTypeOfHelp());
        return "start";
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
