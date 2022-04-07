package com.example.tp3.dto;

import com.example.tp3.Model.Borrow;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDTO {

    private long id;
    private String email;
    private String password;
    private String fullName;
    private int fee;

    List<BorrowDto> borrows = new ArrayList<>();


    public void addBorrow(BorrowDto borrow) {
        borrows.add(borrow);
    }
}
