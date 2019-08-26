package com.teslus.donation.web;


import com.teslus.donation.entities.User;
import com.teslus.donation.services.CountryService;
import com.teslus.donation.services.DocumentService;
import com.teslus.donation.services.UserService;
import com.teslus.donation.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    CountryService countryService;
    @Autowired
    DocumentService documentService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(Model model) {
        model.addAttribute("countryList", countryService.getAll());
        model.addAttribute("documentList", documentService.getAll());
        return new UserRegistrationDto();

    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }

}
