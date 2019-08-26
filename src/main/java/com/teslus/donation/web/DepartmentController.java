package com.teslus.donation.web;


import com.teslus.donation.entities.Department;
import com.teslus.donation.services.CountryService;
import com.teslus.donation.services.DepartmentService;
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
@RequestMapping("admin/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CountryService countryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("countryList", countryService.getAll());
        model.addAttribute("departmentList", departmentService.getAll());
        model.addAttribute("department", new Department());
        return "admin/department";
    }

    @PostMapping("/save")
    public String showdepartment(Department department, Model model){
        departmentService.save(department);
        return "redirect:";//Redirect a "/admin/self/"
    }
    @PostMapping(value = "/delete", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Map delete (@RequestParam("id") int id){
        Map<String, Object> response = new LinkedHashMap<>();
        if(id>0) {
            try {
                departmentService.delete(id);
                response.put("deleted", true);
            } catch (Exception e) {
                LOGGER.error("Failed to delete the item");
            }
        }
        response.put("deleted",false);
        return response;
    }





}
