package fr.dauphine.microservice.reader.service;

import fr.dauphine.microservice.reader.model.Reader;


public interface ReaderServiceProvider {
    Reader create(final Reader reader);
    Reader getById(final Integer id);
    Reader update(Reader reader);
    void delete(Reader reader);
}
