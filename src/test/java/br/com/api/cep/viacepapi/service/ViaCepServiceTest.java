package br.com.api.cep.viacepapi.service;

import br.com.api.cep.viacepapi.exception.FormatCepInvalidException;
import br.com.api.cep.viacepapi.exception.NotFoundException;
import br.com.api.cep.viacepapi.integration.ViaCepFeignIntegration;
import br.com.api.cep.viacepapi.models.CepResponseRepresentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ViaCepServiceTest {
    @Mock
    private ViaCepFeignIntegration viaCepFeignIntegration;

    @InjectMocks
    private ViaCepService service;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        service = new ViaCepService(viaCepFeignIntegration);
    }
    
    @Test
    void testSearchCepSuccess(){
        String cep = "13214194";
        CepResponseRepresentation expectedResponse = new CepResponseRepresentation();
        expectedResponse.setCep(cep);
        expectedResponse.setBairro("Teste");
        expectedResponse.setComplemento("Teste");
        expectedResponse.setDdd("11");
        expectedResponse.setLocalidade("Teste");
        expectedResponse.setIbge("Teste");
        expectedResponse.setLogradouro("Teste");
        expectedResponse.setSiafi("Teste");
        expectedResponse.setUf("Teste");

        when(viaCepFeignIntegration.searchCep(cep)).thenReturn(expectedResponse);

        CepResponseRepresentation actualResponse = service.searchCep(cep);

        assertNotNull(cep);
        assertEquals(expectedResponse, actualResponse);

    }

    @Test
    void testFormatInvalid(){
        String cepFormatInvalid = "1324567-124";

        assertThrows(FormatCepInvalidException.class,
                () -> service.searchCep(cepFormatInvalid));
    }

    @Test
    void testResponseNull(){
        String cepNull = "00000000";

        when(viaCepFeignIntegration.searchCep(cepNull)).thenReturn(null);

        assertThrows(NotFoundException.class, () -> service.searchCep(cepNull));
    }
}