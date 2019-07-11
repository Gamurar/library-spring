package com.example.demo.data.service;


import com.example.demo.data.domain.Publisher;
import com.example.demo.data.domain.dto.PublisherForm;

public interface PublisherService {

    Publisher findById(Long id);

    Publisher save(Publisher publisher);

    Publisher save(PublisherForm publisherForm);

    PublisherForm createPublisherForm(Publisher publisher);

    Publisher createPublisher(PublisherForm publisherForm);

    void deleteById(Long id);
}
