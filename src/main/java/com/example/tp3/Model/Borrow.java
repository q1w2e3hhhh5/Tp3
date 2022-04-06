package com.example.tp3.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

/*    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;*/

    private LocalDateTime localDateTimeOfBorrow;
    private LocalDateTime localDateTimeOfReturn;


}
