package com.example.tp3.dto;

import lombok.Data;

import java.util.List;

@Data
public class DocumentSearchForm {

    private String searchItem;
    private List<DocumentDto> documentsDto;
}

