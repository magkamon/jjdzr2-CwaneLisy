package com.infoshare.controller;

import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.formobjects.NeedRequestForm;
import com.infoshare.service.NeedRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class NeedRequestController {
    private final NeedRequestService needRequestService;

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
    public String createNeedRequestFromForm(@Valid @ModelAttribute("needRequestForm") NeedRequestForm needRequestForm, BindingResult br, Model model) {
        if (br.hasErrors()) {
            List<TypeOfHelp> typeOfHelp = Arrays.asList(TypeOfHelp.values());
            model.addAttribute("types", typeOfHelp);
            return "createNeedRequestForm";
        } else {
            needRequestService.createNeedRequest(needRequestForm.getName(), needRequestForm.getLocation(), needRequestForm.getPhone(), needRequestForm.getTypeOfHelp());
            return "redirect:/printAllNeedRequest";
        }
    }

    @GetMapping("/printAllNeedRequest")
    @ResponseBody
    public List<NeedRequest> printAllNeedRequest() {
        return needRequestService.getAllNeedRequest();
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
