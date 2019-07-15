package com.example.demo.data.service;


import com.example.demo.data.domain.Publisher;

import java.util.List;

public interface PublisherService {

    Publisher findById(Long id);

    List<Publisher> findAll();

    Publisher save(Publisher publisher);

    void deleteById(Long id);
}
