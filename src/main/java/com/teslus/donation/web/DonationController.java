package com.teslus.donation.web;


import com.teslus.donation.entities.Donation;
import com.teslus.donation.entities.Donator;
import com.teslus.donation.entities.User;
import com.teslus.donation.services.DonationService;
import com.teslus.donation.services.DontaorService;
import com.teslus.donation.services.InstitutionService;
import com.teslus.donation.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Date;

@Controller
@RequestMapping("user/donate")
public class DonationController {
    @Autowired
    InstitutionService institutionService;
    @Autowired
    UserService userService;
    @Autowired
    DontaorService dontaorService;
    @Autowired
    DonationService donationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(DonationController.class);





    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("institutionList", institutionService.getAll());
        model.addAttribute("donation", new Donation());
        return "user/donacion";
    }

    @PostMapping("/save")
    public String showdepartment(Donation donation, Principal principal, Model model){
        User user = userService.findByEmail(principal.getName());
        Donator donator = dontaorService.findDonatorByUserId(user.getIdUser());
        donation.setFecha(new Date());
        donation.setIdDonator(donator.getIdDonator());
        donationService.save(donation);
        return "user/index";
    }

    @GetMapping("/all")
    public String donaciones(Model model,Principal principal){
        User user = userService.findByEmail(principal.getName());
        Donator donator = dontaorService.findDonatorByUserId(user.getIdUser());
        model.addAttribute("listDonaciones", donationService.findAllbyIdDonator(donator.getIdDonator()));

        return "user/donaciones";
    }




}
