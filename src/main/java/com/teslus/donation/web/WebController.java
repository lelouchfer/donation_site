package com.teslus.donation.web;

import com.teslus.donation.entities.Department;
import com.teslus.donation.services.DepartmentService;
import com.teslus.donation.services.DonationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WebController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @Autowired
    DepartmentService departmentService;
    @Autowired
    DonationService donationService;

    @PostMapping(value = "/ws/getDepartments", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Map findBasedCountry (@RequestParam("id") int id){
        Map<String, Object> response = new LinkedHashMap<>();
        try{
            List<Department> departmentList =departmentService.findDepartmentsByIdCountry(id);
            response.put("status","success");
            String options="<option value=\"0\"> Seleccione a Department </>";
            for (Department department:departmentList) {
                options+="<option value = \"" +department.getIdDepartment() +"\">"+department.getName()+"</option>";
            }
            response.put("response", options);
        }catch (Exception e){
            LOGGER.error("Failed to load the item");
            response.put("status","failed");
        }
        return response;
    }


    @GetMapping(value = "ws/all", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity getDonationsInfo(){
        Map<String, Object> response = new LinkedHashMap();
        response.put("operation", "success");
        response.put("response", donationService.getAll());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);
    }





}
