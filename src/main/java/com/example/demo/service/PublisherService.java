package com.example.demo.service;

import com.example.demo.domain.Publisher;
import com.example.demo.domain.dto.PublisherForm;

public interface PublisherService {

    Publisher findById(Long id);

    Publisher save(Publisher publisher);

    Publisher save(PublisherForm publisherForm);

    PublisherForm createPublisherForm(Publisher publisher);

    void deleteById(Long id);
}
