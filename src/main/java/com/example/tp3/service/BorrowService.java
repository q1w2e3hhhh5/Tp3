package com.example.tp3.service;

import com.example.tp3.dto.BorrowDto;
import com.example.tp3.model.*;
import com.example.tp3.repository.*;
import com.example.tp3.repository.ClientRepository;
import com.example.tp3.util.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DocumentRepository documentRepository;

    public Borrow createBorrow(Document document, Client client){
        Borrow borrow = Borrow.builder().document(document).client(client).build();
        return borrowRepository.save(borrow);
    }

    @Transactional
    public List<BorrowDto> findBorrowsByClientId(Long clientId){
        List<Borrow> borrows = borrowRepository.findBorrowByClient_Id(clientId);
        List<BorrowDto> borrowDtos  = DtoUtils.getBorrowsDto(borrows);
        return borrowDtos;
    }


    @Transactional
    public List<BorrowDto> findBorrowsByClientEmail(String email){
        List<Borrow> borrows = borrowRepository.findBorrowByClient_Email(email);
        List<BorrowDto> borrowDtos  = DtoUtils.getBorrowsDto(borrows);
        return borrowDtos;
    }

    public Borrow findBorrowByClient_EmailAndAndDocument_Title(String email, String documentTitle){
        return borrowRepository.findBorrowByClient_EmailAndAndDocument_Title(email,documentTitle);
    }

    public void removeBorrowByDocument_Title(String title) {
        borrowRepository.deleteByDocument_Title(title);
    }
}
