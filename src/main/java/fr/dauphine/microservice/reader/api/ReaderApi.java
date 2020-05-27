package fr.dauphine.microservice.reader.api;

import fr.dauphine.microservice.reader.model.Reader;
import fr.dauphine.microservice.reader.service.ReaderServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/readers")
public class ReaderApi {

    @Autowired
    private ReaderServiceProvider readerServiceProvider;

    @PostMapping
    public ResponseEntity<EntityModel<Reader>> create(@RequestBody Reader reader) {
        Reader created = readerServiceProvider.create(reader);
        Link link = getLink(created.getId());
        return new ResponseEntity<>(EntityModel.of(created, link), CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EntityModel<Reader>> getById(@PathVariable("id") Integer id) {
        Optional<Reader> readerOptional = readerServiceProvider.getById(id);
        Reader reader = readerOptional.orElse(new Reader());
        Link link = getLink(id);
        return new ResponseEntity<>(EntityModel.of(reader, link), OK);
    }

    private Link getLink(Integer id) {
        return linkTo(methodOn(ReaderApi.class)
                .getById(id)).withSelfRel();
    }
}
