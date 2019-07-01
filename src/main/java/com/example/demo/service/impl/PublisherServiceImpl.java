package com.example.demo.service.impl;

import com.example.demo.domain.Publisher;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository repository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return repository.save(publisher);
    }
}
