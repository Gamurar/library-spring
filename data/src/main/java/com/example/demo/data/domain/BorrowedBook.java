package com.example.demo.data.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "borrowed_book")
@EntityListeners(AuditingEntityListener.class)
public class BorrowedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Book book;

    @Column(name = "borrow_date")
    @CreatedDate
    private LocalDateTime borrowDate;

}
