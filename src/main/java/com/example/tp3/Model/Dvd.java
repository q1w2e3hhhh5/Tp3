package com.example.tp3.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Dvd extends Document {

    private int TimeLength;

    @Builder
    public Dvd(long id, String title, int publicationYear, String author, String editor, String category, int timeLength, String documentType, int quantity, long borrowTimePeriod) {
        super(id, title, publicationYear, author, editor, category, documentType, quantity, borrowTimePeriod);
        this.TimeLength = timeLength;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t\t" + "Time Length : " + TimeLength + "\n";
    }
}
