package com.teslus.donation.web;


import com.teslus.donation.entities.Country;
import com.teslus.donation.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("admin/country")
public class CountryController {
    @Autowired
    CountryService countryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);




    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("countryList", countryService.getAll());
        model.addAttribute("country", new Country());
        return "admin/country";
    }

    @GetMapping("/show/{id}")
    public String showSave(@PathVariable("id") Integer id, Model model){
        if(id!=null && id!=0)
            model.addAttribute("country", countryService.get(id));
        return "save";
    }

    @PostMapping("/save")
    public String showCountry(Country Country, Model model){
        countryService.save(Country);
        return "redirect:";//Redirect a "/admin/country/"
    }
    @PostMapping(value = "/delete", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Map delete (@RequestParam("id") int id, Model model){
        Map<String, Object> response = new LinkedHashMap<>();
        try{
            countryService.delete(id);
            response.put("deleted",true);
        }catch (Exception e){
            LOGGER.error("Failed to delete the item");
        }
        response.put("deleted",false);
        return response;
    }



}
