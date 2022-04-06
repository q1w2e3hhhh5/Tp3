package com.example.tp3.Repository;

import com.example.tp3.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findDocumentsByTitleContains(String title);

    List<Document> findDocumentsByAuthor(String author);

    List<Document> findDocumentsByPublicationYear(int publicationYear);

    List<Document> findDocumentsByCategory(String category);

    List<Document> findDocumentsByEditor(String editor);

    List<Document> findByDocumentType(String type);
}
