package com.example.demo.data.service.impl;


import com.example.demo.data.domain.Publisher;
import com.example.demo.data.repository.PublisherRepository;
import com.example.demo.data.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository repository;

    @Override
    public Publisher findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Publisher> findAll() {
        return repository.findAll();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return repository.save(publisher);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
