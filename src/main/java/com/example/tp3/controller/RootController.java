package com.example.tp3.controller;

import com.example.tp3.service.ClientService;
import com.example.tp3.service.DocumentService;
import com.example.tp3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    Logger logger = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    public String getRootRequest(Model model) {
        model.addAttribute("pageTitle1", "Library");
        model.addAttribute("h1Text", "Java Town Library");
        return "index";
    }

    @GetMapping("/Client")
    public String getClients(Model model) {
        model.addAttribute("pageTitle", "All Clients");
        var clients = employeeService.findAllClients();
        model.addAttribute("clients", clients);
        return "client";
    }

    @GetMapping("/Documents")
    public String getDocuments(Model model) {
        model.addAttribute("pageTitle", "All Documents");
        var documents = documentService.findDocuments();
        model.addAttribute("documents", documents);
        return "documents";
    }


}
