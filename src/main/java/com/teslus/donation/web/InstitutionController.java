package com.teslus.donation.web;


import com.teslus.donation.entities.Institution;
import com.teslus.donation.services.CountryService;
import com.teslus.donation.services.InstitutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("admin/institution")
public class InstitutionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InstitutionController.class);

    @Autowired
    CountryService countryService;
    @Autowired
    InstitutionService institutionService;
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("countryList", countryService.getAll());
        model.addAttribute("institutionList", institutionService.getAll());
        model.addAttribute("institution", new Institution());
        return "admin/institution";
    }

    @PostMapping("/save")
    public String showinstitution(Institution institution, Model model){
        institutionService.save(institution);
        return "redirect:";//Redirect a "/admin/self/"
    }
    @PostMapping(value = "/delete", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Map delete (@RequestParam("id") int id){
        Map<String, Object> response = new LinkedHashMap<>();
        if(id>0) {
            try {
                institutionService.delete(id);
                response.put("deleted", true);
            } catch (Exception e) {
                LOGGER.error("Failed to delete the item");
            }
        }
        response.put("deleted",false);
        return response;
    }


}
