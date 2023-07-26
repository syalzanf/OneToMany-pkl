package com.pkl.request;

/**
 *
 * @author gecko
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    private String judul;
    private int book_category_id;

}

