package fr.dauphine.microservice.reader.api;

import fr.dauphine.microservice.reader.dto.ReaderDto;
import fr.dauphine.microservice.reader.model.ClientReader;
import fr.dauphine.microservice.reader.model.Reader;
import fr.dauphine.microservice.reader.service.ReaderServiceProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Reader API")
public class ReaderApi {

    @Autowired
    private ReaderServiceProvider readerServiceProvider;

    @PostMapping
    @ApiOperation("Create Reader")
    public ResponseEntity<EntityModel<ReaderDto>> create(@RequestBody ClientReader clientReader) {
        Reader created = readerServiceProvider.create(clientReader.toReader());
        Link link = getLink(created.getId());
        return new ResponseEntity<>(EntityModel.of(new ReaderDto().fill(created), link), CREATED);
    }

    @GetMapping("{id}")
    @ApiOperation("Get Reader by ID")
    public ResponseEntity<EntityModel<ReaderDto>> getById(@PathVariable("id") Integer id) {
       try {
           Reader reader = readerServiceProvider.getById(id);
           Link link = getLink(id);
           return new ResponseEntity<>(EntityModel.of(new ReaderDto().fill(reader), link), OK);
       } catch (NoSuchElementException e) {
           throw new ResponseStatusException(NOT_FOUND,e.getMessage());
       }
    }

    @PutMapping
    @ApiOperation("Update Reader")
    public ResponseEntity<EntityModel<ReaderDto>> update(@RequestBody Reader reader) {
        try {
            Reader updated = readerServiceProvider.update(reader);
            return ResponseEntity.ok().body(EntityModel.of(new ReaderDto().fill(updated), getLink(updated.getId())));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(NOT_FOUND,e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation("Delete Reader")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        readerServiceProvider.delete(new Reader().setId(id));
        return ResponseEntity.ok().build();
    }

    private Link getLink(Integer id) {
        return linkTo(methodOn(ReaderApi.class)
                .getById(id)).withSelfRel();
    }
}
