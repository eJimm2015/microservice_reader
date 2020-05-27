package fr.dauphine.microservice.reader.service;

import fr.dauphine.microservice.reader.model.Reader;

import java.util.Optional;


public interface ReaderServiceProvider {
    Reader create(final Reader reader);
    Optional<Reader> getById(final Integer id);
}
