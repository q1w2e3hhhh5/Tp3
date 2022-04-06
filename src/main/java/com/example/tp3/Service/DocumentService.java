package com.example.tp3.Service;

import com.example.tp3.Model.Document;
import com.example.tp3.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> findDocuments() {
        return documentRepository.findAll();
    }

    public List<Document> findDocumentsByTitle(String title) {
        return documentRepository.findDocumentsByTitleContains(title);
    }

    public List<Document> findDocumentsByAuthor(String author) {
        return documentRepository.findDocumentsByAuthor(author);
    }

    public List<Document> findDocumentsPublicationYear(int publicationYear) {
        return documentRepository.findDocumentsByPublicationYear(publicationYear);
    }

    public List<Document> findDocumentsByCategory(String category) {
        return documentRepository.findDocumentsByCategory(category);
    }

    public List<Document> findDocumentsByEditor(String editor) {
        return documentRepository.findDocumentsByEditor(editor);
    }

    public List<Document> findAllBooks() {
        return documentRepository.findByDocumentType("Book");
    }

    public List<Document> findAllCds() {
        return documentRepository.findByDocumentType("Cd");
    }

    public List<Document> findAllDvds() {
        return documentRepository.findByDocumentType("Dvd");
    }


}
