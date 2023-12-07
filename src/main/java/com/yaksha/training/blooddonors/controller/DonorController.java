package com.yaksha.training.blooddonors.controller;

import com.yaksha.training.blooddonors.entity.Donor;
import com.yaksha.training.blooddonors.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
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

import javax.validation.Valid;
import java.util.List;


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

    @GetMapping(value = {"/list", "/"})
    public String listDonors(Model model) {
        List<Donor> donors = donorService.getDonors();
        model.addAttribute("donors", donors);
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

    @PostMapping("/search")
    public String searchDonors(@RequestParam("theSearchName") String theSearchName,
                               Model theModel) {

        List<Donor> theDonors = donorService.searchDonors(theSearchName);
        theModel.addAttribute("donors", theDonors);
        return "list-donors";
    }
}
