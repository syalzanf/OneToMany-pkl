package com.pkl.repository;

import com.pkl.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer>{
    List<Book> findByJudul(String name);
}

