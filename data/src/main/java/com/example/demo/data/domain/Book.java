package com.example.demo.data.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Book implements Serializable {

    @Id
    private String isbn;

    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="publisher_id")
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "book_author",
            joinColumns = { @JoinColumn(name = "book_isbn") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") })
    private List<Author> authors = new ArrayList<>();


    @Column(name = "publish_year", columnDefinition="VARCHAR(4)")
    private String publishYear;

    private Integer copies;

    private String picture;

    public static Book fromISBN(String bookISBN) {
        Book book = new Book();
        book.setIsbn(bookISBN);

        return book;
    }
}