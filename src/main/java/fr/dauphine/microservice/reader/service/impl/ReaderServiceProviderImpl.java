package fr.dauphine.microservice.reader.service.impl;
import fr.dauphine.microservice.reader.model.Reader;
import fr.dauphine.microservice.reader.repository.ReaderRepository;
import fr.dauphine.microservice.reader.service.ReaderServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReaderServiceProviderImpl implements ReaderServiceProvider {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public Reader create(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public Reader getById(Integer id) {
        Optional<Reader> byId = readerRepository.findById(id);
        if (byId.isPresent()) return byId.get();
        throw new NoSuchElementException(String.format("Le lecteur n°%s n'existe pas",id));
    }

    @Override
    public Reader update(Reader reader) {
        Optional<Reader> byId = readerRepository.findById(reader.getId());
        if(byId.isPresent())return readerRepository.save(byId.get().update(reader));
        throw new NoSuchElementException(String.format("Le lecteur n°%s n'existe pas", reader.getId()));
    }

    @Override
    public void delete(Reader reader) {
        readerRepository.delete(reader);
    }
}
