package com.sturequests.webb.controller;

import com.sturequests.webb.dto.StuRequestDto;
import com.sturequests.webb.models.StuRequest;
import com.sturequests.webb.service.StuRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StuRequestController {
    private StuRequestService stuRequestService;

    @Autowired
    public StuRequestController(StuRequestService stuRequestService)
    {
        this.stuRequestService = stuRequestService;
    }

//    @GetMapping("/requis")
//    public String listRequests(Model model) {
//        List<StuRequestDto> requs = stuRequestService.findAllRequests;
//        model.addAttribute("requs", requs);
//        return "requis-list";
//    }

    @GetMapping("/requis/{requiId}/editexof")
    public String editRequisFormexof(@PathVariable("requiId") Long requiId, Model model){
        StuRequestDto stuRequ = stuRequestService.findRequestById(requiId);
        model.addAttribute("stuRequ", stuRequ);
        return "requis-editexof";

    }

    @PostMapping("/requis/{requiId}/editexof")
    public String updateRequiexof(@PathVariable("requiId") Long requiId,
                              @Validated @ModelAttribute("stuRequ") StuRequestDto stuRequ,
                              BindingResult result, Model model){
        if(result.hasErrors())
        {
            model.addAttribute("stuRequ",stuRequ);
            return "requis-editexof";
        }
        stuRequ.setIdent(requiId);
        stuRequestService.updateRequest(stuRequ);
        return "redirect:/requisexof";
    }

    @GetMapping("/requis/{requiId}/edithod")
    public String editRequisFormhod(@PathVariable("requiId") Long requiId, Model model){
        StuRequestDto stuRequ = stuRequestService.findRequestById(requiId);
        model.addAttribute("stuRequ", stuRequ);
        return "requis-edithod";

    }

    @PostMapping("/requis/{requiId}/edithod")
    public String updateRequihod(@PathVariable("requiId") Long requiId,
                                  @Validated @ModelAttribute("stuRequ") StuRequestDto stuRequ,
                                  BindingResult result, Model model){
        if(result.hasErrors())
        {
            model.addAttribute("stuRequ",stuRequ);
            return "requis-edithod";
        }
        stuRequ.setIdent(requiId);
        stuRequestService.updateRequest(stuRequ);
        return "redirect:/requishod";
    }
    @GetMapping("/requis/{requiId}/edit")
    public String editRequisForm(@PathVariable("requiId") Long requiId, Model model){
        StuRequestDto stuRequ = stuRequestService.findRequestById(requiId);
        model.addAttribute("stuRequ", stuRequ);
        return "requis-edit";

    }

    @PostMapping("/requis/{requiId}/edit")
    public String updateRequi(@PathVariable("requiId") Long requiId,
                               @Validated @ModelAttribute("stuRequ") StuRequestDto stuRequ,
                                 BindingResult result, Model model){
        if(result.hasErrors())
        {
            model.addAttribute("stuRequ",stuRequ);
            return "requis-edit";
        }
        stuRequ.setIdent(requiId);
        stuRequestService.updateRequest(stuRequ);
        return "redirect:/requislect";
    }
    @GetMapping("/requis")
    public String listRequis(Model model)
    {
        List<StuRequestDto> requis = stuRequestService.findAllRequests();
        model.addAttribute("requis", requis);
        return "requis-list";
    }

    @GetMapping("/requislect")
    public String listRequisLect(Model model)
    {
        List<StuRequestDto> requis = stuRequestService.findAllRequests();
        model.addAttribute("requis", requis);
        return "requis-lect";
    }

    @GetMapping("/requisexof")
    public String listRequisexof(Model model)
    {
        List<StuRequestDto> requis = stuRequestService.findAllRequests();
        model.addAttribute("requis", requis);
        return "requis-exof";
    }
    @GetMapping("/requishod")
    public String listRequishod(Model model)
    {
        List<StuRequestDto> requis = stuRequestService.findAllRequests();
        model.addAttribute("requis", requis);
        return "requis-hod";
    }


    @GetMapping("/requi/new")
    public String createRequiForm(Model model)
    {
        StuRequest stuRequest = new StuRequest();
        model.addAttribute("stuRequest", stuRequest);
        return "requi-create";
    }

    @PostMapping("/requi/new")
    public String saveRequi(@ModelAttribute("stuRequest") StuRequestDto stuRequestDto){
        if(stuRequestDto.getRequestStatus() == null)
        {
            stuRequestDto.setRequestStatus("PENDING");
            stuRequestDto.setHodResponse("PENDING");
            stuRequestDto.setExamOfficerResponse("PENDING");
            stuRequestDto.setLecturerResponse("PENDING");
        }
        stuRequestService.saveRequest(stuRequestDto);
        return "redirect:/requis";
    }

}
