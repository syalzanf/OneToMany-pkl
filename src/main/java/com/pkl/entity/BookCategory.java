package com.pkl.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author gecko
 */
@Entity
@Table(name = "book_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCategory {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bookCategory",cascade = CascadeType.ALL)
    private Set<Book> books;

    
    public BookCategory(String name){
        this.name = name;
    }
    
    
    @Override
    public String toString() {
        String result = String.format(
                "Category[id=%d, name='%s']%n",
                id, name);
        if (books != null) {
            for(Book book : books) {
                result += String.format(
                        "Book[id=%d, name='%s']%n",
                        book.getId(), book.getJudul());
            }
        }
        
        return result;
    }
    
}
