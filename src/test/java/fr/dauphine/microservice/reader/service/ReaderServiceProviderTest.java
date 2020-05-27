package fr.dauphine.microservice.reader.service;

import fr.dauphine.microservice.reader.model.Reader;
import fr.dauphine.microservice.reader.repository.ReaderRepository;
import fr.dauphine.microservice.reader.service.impl.ReaderServiceProviderImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReaderServiceProviderTest {

    @Mock
    ReaderRepository readerRepository;

    @InjectMocks
    ReaderServiceProviderImpl readerServiceProvider;

    @Test
    public void testCreateReader() {
        Reader reader = new Reader();
        when(readerRepository.save(reader)).thenReturn(reader.setId(12345));
        assertEquals(Integer.valueOf(12345), readerServiceProvider.create(reader).getId());
    }

    @Test
    public void testGetById() {
        int id = 12345;
        Reader reader = new Reader().setId(id);
        when(readerRepository.findById(id)).thenReturn(Optional.of(reader));
        assertEquals(Optional.of(reader), readerServiceProvider.getById(id));
    }
}
