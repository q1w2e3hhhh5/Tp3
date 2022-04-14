package com.example.tp3.controller;

import com.example.tp3.dto.*;
import com.example.tp3.model.Client;
import com.example.tp3.model.Dvd;
import com.example.tp3.service.ClientService;
import com.example.tp3.service.DocumentService;
import com.example.tp3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @GetMapping("/findDocumentByx")
    public String findDocumentBy(Model model) {
        DocumentSearchForm documentSearchForm = new DocumentSearchForm();
        model.addAttribute("documentSearchForm", documentSearchForm);

        return "findDocument";
    }


    @GetMapping("/CreateClient")
    public String ClientCreate(Model model) {
        var clientDto = new ClientDto();
        model.addAttribute("client", clientDto);
        return "CreateClient";
    }


    @PostMapping("/CreateClient")
    public RedirectView clientPost(@ModelAttribute ClientDto clientDto, RedirectAttributes redirectAttributes) {
        final Client client = clientService.createClient(clientDto);
        clientDto.setId(client.getId());

        redirectAttributes.addFlashAttribute("clients", clientDto);

        RedirectView redirectView = new RedirectView();//this goes to the next mapping thingy...
        redirectView.setContextRelative(true);
        redirectView.setUrl("/Client");          //this one more precisely
        return redirectView;
    }


    @GetMapping("/CreateDocument")
    public String getCreateDocuments(Model model) {
        model.addAttribute("dvd",new DvdDto());
/*        model.addAttribute("cd",new CdDto());
        model.addAttribute("book",new BookDto());*/
        return "CreateDocument";
    }


    @PostMapping("/DvdCreate")
    public RedirectView dvdPost(@ModelAttribute DvdDto dvdDto, RedirectAttributes redirectAttributes) {
        final Dvd dvd = employeeService.createDvd(dvdDto);
        dvdDto.setId(dvd.getId());

        redirectAttributes.addFlashAttribute("dvd", dvdDto);
        RedirectView redirectView = new RedirectView();//this goes to the next mapping thingy...
        redirectView.setContextRelative(true);
        redirectView.setUrl("/Documents");          //this one more precisely
        return redirectView;
    }

    /*

    @PostMapping("/findDocumentByx")
    public String findDocumentBy(Model model,@ModelAttribute DocumentSearchForm documentSearchForm){
        List<DocumentDto> documents = documentService.findDocumentsByAuthor(documentSearchForm.getSearchItem());
        List<DocumentDto> documentsByCategory = documentService.findDocumentsByCategory(documentSearchForm.getSearchItem());
        List<DocumentDto> documentFound = new ArrayList<>();
    }
*/


}
