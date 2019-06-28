package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "borrowed_book")
public class BorrowedBook {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Book book;

    @Column(name = "borrow_date")
    private Date borrowDate;

}
