package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "isbn")
    private String ISBN;


    @Column(name = "name")
    private String name;


    @Column(name = "publisher_id")
    private Long publisherId;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "book_author",
            joinColumns = { @JoinColumn(name = "book_isbn") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") })
    private Set<Author> authors = new HashSet<>();


    @Column(name = "publish_date")
    private Date publishDate;


    @Column(name = "count")
    private Integer count;

}