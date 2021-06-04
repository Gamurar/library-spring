package com.example.demo.api.rest;


import com.example.demo.data.domain.Author;
import com.example.demo.data.domain.Publisher;
import com.example.demo.data.service.PublisherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "Publisher API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Publisher Service"})
public class PublisherRestController {

    private final PublisherService publisherService;

    @PostMapping(value = "/publishers")
    @ApiOperation(value = "Create new publisher")
    public Publisher createPublisher(@Valid @RequestBody Publisher publisher) {
        log.debug("REST request to save Publisher : {}", publisher);
        publisher.setId(null);
        return publisherService.save(publisher);
    }

    @PutMapping(value = "/publishers")
    @ApiOperation(value = "Update information about a publisher")
    public Publisher updatePublisher(@Valid @RequestBody Publisher publisher) {
        log.debug("REST request to update Publisher : {}", publisher);
        if (publisher.getId() == null) {
            log.error("Invalid ID");
            return null;
        }

        return publisherService.save(publisher);
    }

    @GetMapping("/publishers")
    @ApiOperation(value = "Get list of all publishers in the database")
    public List<Publisher> getAllPublishers() {
        log.debug("REST request to get all publishers");

        return publisherService.findAll();
    }

    @GetMapping("/publishers/{id}")
    @ApiOperation(value = "Get specific publisher by id")
    public Publisher getPublisher(@ApiParam(value = "ID of the publisher about which to get information", required = true)
                                @PathVariable Long id) {
        log.debug("REST request to get publisher with id " + id);

        return publisherService.findById(id);
    }

    @DeleteMapping("/publishers/{id}")
    @ApiOperation(value = "Delete a publisher by id")
    public String deletePublisher(@ApiParam(value = "ID of the publisher to be deleted", required = true)
                                   @PathVariable Long id) {
        log.debug("REST request to delete publisher with id " + id);
        publisherService.deleteById(id);

        return "The publisher with id " + id + " deleted!";
    }

}
