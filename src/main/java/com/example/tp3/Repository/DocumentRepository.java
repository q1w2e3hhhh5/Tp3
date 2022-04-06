package com.example.tp3.Repository;

import com.example.tp3.Model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document,Long> {

    List<Document> findBooksByTitleContains(String title);

    List<Document> findBooksByAuthor(String author);

    List<Document> findBooksByPublicationYear(int publicationYear);

    List<Document> findBooksByCategory(String category);
}
