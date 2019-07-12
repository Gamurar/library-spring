package com.example.demo.data.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "borrowed_book")
@EntityListeners(AuditingEntityListener.class)
public class BorrowedBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "book_isbn")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "isbn")
    @JsonIdentityReference(alwaysAsId = true)
    private Book book;

    @Column(name = "borrow_date")
    @CreatedDate
    private LocalDateTime borrowDate;

}
