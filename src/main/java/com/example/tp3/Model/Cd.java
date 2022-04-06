package com.example.tp3.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cd extends Document {
    private int TimeLength;


    @Builder
    public Cd(long id, String title, int publicationYear, String author, String editor, String genre, int timeLength, String documentType, int quantity, long borrowTimePeriod) {
        super(id, title, publicationYear, author, editor, genre, documentType, quantity, borrowTimePeriod);
        TimeLength = timeLength;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t\t" + "Time Length : " + TimeLength + "\n";
    }
}
