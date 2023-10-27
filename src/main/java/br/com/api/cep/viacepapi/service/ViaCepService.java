package br.com.api.cep.viacepapi.service;

import br.com.api.cep.viacepapi.integration.ViaCepFeignIntegration;
import br.com.api.cep.viacepapi.exception.FormatCepInvalidException;
import br.com.api.cep.viacepapi.exception.NotFoundException;
import br.com.api.cep.viacepapi.models.CepResponseRepresentation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private final ViaCepFeignIntegration feignClient;

    public CepResponseRepresentation searchCep(String cep) {
        if(cep.length() != 8){
            throw new FormatCepInvalidException("Formato de cep {0} invalido ", cep);
        }

        var response = feignClient.searchCep(cep);

        if (Objects.isNull(response)) {
            throw new NotFoundException("CEP não encontrado.");
        }
        return response;
    }
}
