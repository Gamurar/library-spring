package com.example.demo.data.service;


import com.example.demo.data.domain.Publisher;

public interface PublisherService {

    Publisher findById(Long id);

    Publisher save(Publisher publisher);

    void deleteById(Long id);
}
