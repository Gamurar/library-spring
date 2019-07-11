package com.example.demo.data.service.impl;


import com.example.demo.data.domain.Publisher;
import com.example.demo.data.domain.dto.PublisherForm;
import com.example.demo.data.repository.PublisherRepository;
import com.example.demo.data.service.PublisherService;
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
    public Publisher findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return repository.save(publisher);
    }

    @Override
    public Publisher save(PublisherForm publisherForm) {
        Publisher publisher = new Publisher();
        if (publisherForm.getId() != -1L) {
            publisher.setId(publisherForm.getId());
        }

        publisher.setName(publisherForm.getName());

        return repository.save(publisher);
    }

    @Override
    public PublisherForm createPublisherForm(Publisher publisher) {
        PublisherForm publisherForm = new PublisherForm();
        publisherForm.setId(publisher.getId());
        publisherForm.setName(publisher.getName());

        return publisherForm;
    }

    @Override
    public Publisher createPublisher(PublisherForm publisherForm) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherForm.getName());
        if (publisherForm.getId() != null) {
            publisher.setId(publisherForm.getId());
        }

        return publisher;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
