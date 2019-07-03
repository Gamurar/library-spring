package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Authority {
    @Id
    @Enumerated(EnumType.STRING)
    private AuthorityType name;
    public Authority() {}
    public Authority(AuthorityType name) {
        this.name = name;
    }
}