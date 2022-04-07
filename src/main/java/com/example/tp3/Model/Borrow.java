package com.example.tp3.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "document_id")
  //  @OneToMany(fetch = FetchType.EAGER, mappedBy = "topic", cascade = CascadeType.ALL)
    private Document document;

    private LocalDateTime localDateTimeOfBorrow;
    private LocalDateTime localDateTimeOfReturn;


    public Borrow(Optional<Document> documentById) {
        this.document = document;
        this.localDateTimeOfBorrow = LocalDateTime.now();
        if(document.getDocumentType().equals("Book")){
            this.localDateTimeOfReturn = LocalDateTime.now().plusWeeks(3);
        }else if(document.getDocumentType().equals("Cd")){
            this.localDateTimeOfReturn = LocalDateTime.now().plusWeeks(2);
        }else if (document.getDocumentType().equals("Dvd")){
            this.localDateTimeOfReturn = LocalDateTime.now().plusWeeks(1);
        }
    }
}
