package com.teslus.donation.web;


import com.teslus.donation.entities.Document;
import com.teslus.donation.services.DocumentService;
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
@RequestMapping("admin/document")
public class DocumentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    DocumentService documentService;


    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("documentList", documentService.getAll());
        model.addAttribute("document", new Document());
        return "admin/document";
    }

    @GetMapping("/show/{id}")
    public String showSave(@PathVariable("id") Integer id, Model model){
        if(id!=null && id!=0)
            model.addAttribute("document", documentService.get(id));
        return "save";
    }

    @PostMapping("/save")
    public String showdocument(Document document, Model model){
        documentService.save(document);
        return "redirect:";//Redirect a "/admin/document/"
    }
    @PostMapping(value = "/delete", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Map delete (@RequestParam("id") int id){
        Map<String, Object> response = new LinkedHashMap<>();
        if(id>0) {
            try {
                documentService.delete(id);
                response.put("deleted", true);
            } catch (Exception e) {
                LOGGER.error("Failed to delete the item");
            }
        }
        response.put("deleted",false);
        return response;
    }



}
