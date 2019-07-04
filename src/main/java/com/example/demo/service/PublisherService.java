package com.example.demo.service;

import com.example.demo.domain.Publisher;
import com.example.demo.domain.dto.PublisherForm;

public interface PublisherService {

    Publisher save(Publisher publisher);

    PublisherForm createPublisherForm(Publisher publisher);
}
