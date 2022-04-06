package com.example.tp3.Service;

import com.example.tp3.Model.*;
import com.example.tp3.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository adminRepository;

    @Autowired
    private DocumentRepository documentRepository;


    public Employee createEmployee(String email, String passwords, String fullName) {
        return adminRepository.save(new Employee(email, passwords, fullName));
    }

    public Book createBook(String title, int nbPages, String author, String category, String editor, int publicationYear, int quantity) {
        Book book = Book.builder().title(title).nbPages(nbPages).category(category).author(author)
                .editor(editor).publicationYear(publicationYear).documentType("Book").quantity(quantity).borrowTimePeriod(3).build();
        return documentRepository.save(book);
    }

    public Cd createCd(String title, int publicationYear, String author, String editor, String category, int timeLength, int quantity) {
        Cd cd = Cd.builder().title(title).publicationYear(publicationYear).author(author).editor(editor).genre(category)
                .timeLength(timeLength).documentType("Cd").quantity(quantity).borrowTimePeriod(2).build();
        return documentRepository.save(cd);
    }

    public Dvd createDvd(String title, int publicationYear, String author, String editor, String genre, int timeLength, int quantity) {
        Dvd dvd = Dvd.builder().title(title).publicationYear(publicationYear).author(author).editor(editor).genre(genre)
                .timeLength(timeLength).documentType("Dvd").quantity(quantity).borrowTimePeriod(1).build();
        return documentRepository.save(dvd);
    }


    public List<Document> findDocuments() {
        return documentRepository.findAll();
    }

    public List<Document> findDocumentsByTitle(String title) {
        return documentRepository.findBooksByTitleContains(title);
    }

    public List<Document> findDocumentsByAuthor(String author) {
        return documentRepository.findBooksByAuthor(author);
    }

    public List<Document> findDocumentsPublicationYear(int publicationYear) {
        return documentRepository.findBooksByPublicationYear(publicationYear);
    }

    public List<Document> findDocumentsByCategory(String category) {
        return documentRepository.findBooksByCategory(category);
    }

}
