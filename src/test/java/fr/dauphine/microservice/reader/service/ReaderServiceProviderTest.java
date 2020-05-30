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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

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
        assertEquals(reader, readerServiceProvider.getById(id));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetByUknownId() {
        int id = 12345;
        when(readerRepository.findById(id)).thenReturn(Optional.empty());
        readerServiceProvider.getById(id);
    }

    @Test
    public void testUpdateReader() {
        Reader reader = new Reader().setId(1).setFirstName("Friedrich");
        when(readerRepository.findById(reader.getId())).thenReturn(Optional.of(reader));
        when(readerRepository.save(reader)).thenReturn(reader.setFirstName("Emil"));
        reader.setFirstName("Emil");
        assertEquals(reader, readerServiceProvider.update(reader));
    }

    @Test
    public void testDeleteReader() {
        Reader reader = new Reader().setId(1);
        doNothing().when(readerRepository).delete(reader);
        readerServiceProvider.delete(reader);
        verify(readerRepository, times(1)).delete(reader);
    }
}
