package com.pkl.repository;

import com.pkl.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** 
*
* @author gecko
*/
@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer >{
    
}

