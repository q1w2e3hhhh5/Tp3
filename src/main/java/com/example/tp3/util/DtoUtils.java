package com.example.tp3.util;

import com.example.tp3.Model.*;
import com.example.tp3.dto.*;

public class DtoUtils {


    public static BorrowDto toDto(Borrow borrow) {
        BorrowDto borrowDto = new BorrowDto();

        borrowDto.setId(borrow.getId());
        borrowDto.setDocumentDto(getDocumentDto(borrow.getDocument()));
        borrowDto.setLocalDateTimeOfBorrow(borrow.getLocalDateTimeOfBorrow());
        borrowDto.setLocalDateTimeOfReturn(borrow.getLocalDateTimeOfReturn());

        return borrowDto;
    }

    public static ClientDTO getClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPassword(client.getPassword());
        clientDTO.setFullName(client.getFullName());
        for (Borrow b : client.getBorrows()) {
            clientDTO.addBorrow(DtoUtils.toDto(b));
        }
        return clientDTO;
    }


    public static DocumentDto getDocumentDto(Document document){
        DocumentDto documentDto = new DocumentDto();

        documentDto.setId(document.getId());
        documentDto.setDocumentType(document.getDocumentType());
        documentDto.setAuthor(document.getAuthor());
        documentDto.setCategory(documentDto.getCategory());
        documentDto.setEditor(document.getEditor());
        documentDto.setQuantity(document.getQuantity());
        documentDto.setTitle(document.getTitle());
        documentDto.setPublicationYear(document.getPublicationYear());
        documentDto.setBorrowTimePeriod(document.getBorrowTimePeriod());

        return documentDto;

    }
}
