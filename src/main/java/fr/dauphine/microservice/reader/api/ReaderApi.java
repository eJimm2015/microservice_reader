package fr.dauphine.microservice.reader.api;

import fr.dauphine.microservice.reader.dto.ReaderDto;
import fr.dauphine.microservice.reader.model.Reader;
import fr.dauphine.microservice.reader.service.ReaderServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/readers")
public class ReaderApi {

    @Autowired
    private ReaderServiceProvider readerServiceProvider;

    @PostMapping
    public ResponseEntity<EntityModel<ReaderDto>> create(@RequestBody Reader reader) {
        Reader created = readerServiceProvider.create(reader);
        Link link = getLink(created.getId());
        return new ResponseEntity<>(EntityModel.of(new ReaderDto().fill(created), link), CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EntityModel<ReaderDto>> getById(@PathVariable("id") Integer id) {
       try {
           Reader reader = readerServiceProvider.getById(id);
           Link link = getLink(id);
           return new ResponseEntity<>(EntityModel.of(new ReaderDto().fill(reader), link), OK);
       } catch (NoSuchElementException e) {
           throw new ResponseStatusException(NOT_FOUND,e.getMessage());
       }
    }

    private Link getLink(Integer id) {
        return linkTo(methodOn(ReaderApi.class)
                .getById(id)).withSelfRel();
    }
}
