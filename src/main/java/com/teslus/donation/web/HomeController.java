package com.teslus.donation.web;

import com.teslus.donation.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/servicexxx")

public class HomeController {

    @Autowired
    DonationService donationService;
    @RequestMapping("/all")
    public ResponseEntity getAll() {
            Map<String, Object> response = new LinkedHashMap();
            response.put("operation", "success");
            response.put("response", donationService.getAll());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);
    }




}
