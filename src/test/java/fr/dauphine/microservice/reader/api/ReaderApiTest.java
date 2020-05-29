package fr.dauphine.microservice.reader.api;

import fr.dauphine.microservice.reader.dto.ReaderDto;
import fr.dauphine.microservice.reader.model.Reader;
import fr.dauphine.microservice.reader.service.ReaderServiceProvider;
import fr.dauphine.microservice.reader.service.impl.ReaderServiceProviderImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RunWith(MockitoJUnitRunner.class)
public class ReaderApiTest {

    @Mock
    private ReaderServiceProviderImpl readerServiceProvider;

    @InjectMocks
    private ReaderApi readerApi;

    @Test
    public void testCreation() {
        Reader reader = new Reader();
        Mockito.when(readerServiceProvider.create(reader)).thenReturn(reader.setId(12345));
        ResponseEntity<EntityModel<ReaderDto>> entityModelResponseEntity = readerApi.create(reader);
        EntityModel<ReaderDto> body = entityModelResponseEntity.getBody();
        Assert.assertNotNull(body);
        ReaderDto content = body.getContent();
        Assert.assertEquals(new ReaderDto().fill(reader.setId(12345)),content);
    }

    @Test
    public void testGetById() {
        Reader reader = new Reader().setId(12345);
        Mockito.when(readerServiceProvider.getById(12345)).thenReturn(reader);
        ResponseEntity<EntityModel<ReaderDto>> entityModelResponseEntity= readerApi.getById(12345);
        EntityModel<ReaderDto> body = entityModelResponseEntity.getBody();
        Assert.assertNotNull(body);
        ReaderDto content = body.getContent();
        Assert.assertEquals(new ReaderDto().fill(reader),content);
    }

    @Test(expected = ResponseStatusException.class)
    public  void testGetByUnknownId(){
        Mockito.when(readerServiceProvider.getById(12345)).thenThrow(new NoSuchElementException());
        readerApi.getById(12345);

    }
}
