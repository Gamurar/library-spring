package com.example.demo.data.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

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