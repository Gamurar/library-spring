package com.example.demo.web.service.dto;

import com.example.demo.data.domain.Publisher;
import com.example.demo.data.domain.dto.PublisherDTO;
import com.example.demo.data.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherDTOService {

    private final PublisherService publisherService;

    public PublisherDTO createPublisherForm(Publisher publisher) {
        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setId(publisher.getId());
        publisherDTO.setName(publisher.getName());

        return publisherDTO;
    }

    public Publisher createPublisher(PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherDTO.getName());
        if (publisherDTO.getId() != null) {
            publisher.setId(publisherDTO.getId());
        }

        return publisher;
    }

    public Publisher save(PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher();
        if (publisherDTO.getId() != -1L) {
            publisher.setId(publisherDTO.getId());
        }

        publisher.setName(publisherDTO.getName());

        return publisherService.save(publisher);
    }
}
