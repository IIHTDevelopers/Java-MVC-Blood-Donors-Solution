package com.yaksha.training.blooddonors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaksha.training.blooddonors.entity.Donor;
import com.yaksha.training.blooddonors.service.DonorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = {"/donor", "/"})
public class DonorController {

    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @Autowired
    private DonorService donorService;

    @GetMapping(value = {"/list", "/", "/search"})
    public String listDonors(@RequestParam(value = "theSearchName", required = false) String theSearchName,
                             @PageableDefault(size = 5) Pageable pageable, Model theModel) {
        Page<Donor> donors = donorService.searchDonors(theSearchName,pageable);
        theModel.addAttribute("donors", donors.getContent());
        theModel.addAttribute("theSearchName", theSearchName != null ? theSearchName : "");
        theModel.addAttribute("totalPage", donors.getTotalPages());
        theModel.addAttribute("page", pageable.getPageNumber());
        theModel.addAttribute("sortBy", pageable.getSort().get().count() != 0 ?
                pageable.getSort().get().findFirst().get().getProperty() + "," + pageable.getSort().get().findFirst().get().getDirection() : "");

        return "list-donors";
    }

    @GetMapping("/addDonorForm")
    public String showFormForAdd(Model model) {
        Donor donor = new Donor();
        model.addAttribute("donor", donor);
        return "add-donor-form";
    }

    @PostMapping("/saveDonor")
    public String saveDonor(@Valid @ModelAttribute("donor") Donor donor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            if(donor.getId() != null) {
                return "update-donor-form";
            }
            return "add-donor-form";
        } else {
            donorService.saveDonor(donor);
            return "redirect:/donor/list";
        }
    }

    @GetMapping("/updateDonorForm")
    public String showFormForUpdate(@RequestParam("donorId") Long id, Model model) {
        Donor donor = donorService.getDonor(id);
        model.addAttribute("donor", donor);
        return "update-donor-form";
    }

    @GetMapping("/delete")
    public String deleteDonor(@RequestParam("donorId") Long id) {
        donorService.deleteDonor(id);
        return "redirect:/donor/list";
    }
    
}
