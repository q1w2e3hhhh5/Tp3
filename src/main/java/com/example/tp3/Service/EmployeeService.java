package com.example.tp3.Service;

import com.example.tp3.Model.Book;
import com.example.tp3.Model.Employee;
import com.example.tp3.Repository.AdminRepository;
import com.example.tp3.Repository.BookRepository;
import com.example.tp3.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository adminRepository;

    @Autowired
    private BookRepository bookRepository;



    public Employee createEmployee(String email, String passwords, String fullName) {
        return adminRepository.save(new Employee(email,passwords,fullName));
    }

    public Book createBook(String title, int nbPages, String type, String author, String genre, String editor, int publicationYear,int quantity) {
        Book book = Book.builder().title(title).nbPages(nbPages).type(type).genre(genre).author(author)
                .editor(editor).publicationYear(publicationYear).documentType("Book").quantity(quantity).build();
        return bookRepository.save(book);
    }
}
