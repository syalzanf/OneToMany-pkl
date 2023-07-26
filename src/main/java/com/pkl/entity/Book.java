package com.pkl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author gecko
 */

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String judul;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "book_category_id")
    private BookCategory bookCategory;

    public Book(String judul, BookCategory bookCategory) {
        this.judul = judul;
        this.bookCategory = bookCategory;
    }

}

