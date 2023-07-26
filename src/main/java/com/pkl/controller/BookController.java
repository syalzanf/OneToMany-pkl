package com.pkl.controller;

import com.pkl.entity.Book;
import com.pkl.entity.BookCategory;
import com.pkl.request.BookRequest;
import com.pkl.repository.BookCategoryRepository;
import com.pkl.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookRequest book) {
        BookCategory bookCategory = bookCategoryRepository.getById(book.getBook_category_id());
        Book bookEntity = new Book(book.getJudul(), bookCategory);
        Book savedBook = bookRepository.save(bookEntity);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add other CRUD operations (e.g., updateBook, deleteBook) as needed.
}
