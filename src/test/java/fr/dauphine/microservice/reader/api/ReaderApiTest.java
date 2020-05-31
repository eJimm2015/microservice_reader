package fr.dauphine.microservice.reader.api;

import fr.dauphine.microservice.reader.dto.ReaderDto;
import fr.dauphine.microservice.reader.model.ClientReader;
import fr.dauphine.microservice.reader.model.Reader;
import fr.dauphine.microservice.reader.service.impl.ReaderServiceProviderImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReaderApiTest {

    @Mock
    private ReaderServiceProviderImpl readerServiceProvider;

    @InjectMocks
    private ReaderApi readerApi;

    @Test
    public void testCreation() {
        ClientReader clientReader = new ClientReader();
        Reader reader = new Reader();
        when(readerServiceProvider.create(any())).thenReturn(reader.setId(12345));
        ResponseEntity<EntityModel<ReaderDto>> entityModelResponseEntity = readerApi.create(clientReader);
        EntityModel<ReaderDto> body = entityModelResponseEntity.getBody();
        assertNotNull(body);
        ReaderDto content = body.getContent();
        Assert.assertEquals(new ReaderDto().fill(reader.setId(12345)),content);
    }

    @Test
    public void testGetById() {
        Reader reader = new Reader().setId(12345);
        when(readerServiceProvider.getById(12345)).thenReturn(reader);
        ResponseEntity<EntityModel<ReaderDto>> entityModelResponseEntity= readerApi.getById(12345);
        EntityModel<ReaderDto> body = entityModelResponseEntity.getBody();
        assertNotNull(body);
        ReaderDto content = body.getContent();
        Assert.assertEquals(new ReaderDto().fill(reader),content);
    }

    @Test(expected = ResponseStatusException.class)
    public void testGetByUnknownId(){
        when(readerServiceProvider.getById(12345)).thenThrow(new NoSuchElementException());
        readerApi.getById(12345);

    }

    @Test
    public void testUpdate() {
        Reader reader = new Reader().setId(1).setFamilyName("Nietzsche");
        when(readerServiceProvider.update(reader)).thenReturn(reader.setFamilyName("Stirner"));
        reader.setFamilyName("Stirner");
        ResponseEntity<EntityModel<ReaderDto>> update = readerApi.update(reader);
        EntityModel<ReaderDto> body = update.getBody();
        assertNotNull(body);
        ReaderDto content = body.getContent();
        assertEquals(new ReaderDto().fill(reader), content);
    }

    @Test
    public void testDelete() {
        Reader reader = new Reader().setId(1);
        doNothing().when(readerServiceProvider).delete(reader);
        readerApi.delete(1);
        verify(readerServiceProvider, times(1)).delete(reader);
    }

}
