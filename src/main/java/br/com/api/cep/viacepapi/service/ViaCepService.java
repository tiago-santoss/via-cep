package br.com.api.cep.viacepapi.service;

import br.com.api.cep.viacepapi.client.ViaCepFeignClient;
import br.com.api.cep.viacepapi.exception.FormatoCepInvalidoException;
import br.com.api.cep.viacepapi.exception.NotFoundException;
import br.com.api.cep.viacepapi.models.CepResponseRepresentation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private final ViaCepFeignClient feignClient;

    public CepResponseRepresentation searchCep(String cep) {
        try {
            var response = feignClient.searchCep(cep);

            if (Objects.isNull(response) || response.getCep() == null) {
                throw new NotFoundException("CEP não encontrado.");
            }

            return response;
        } catch (FormatoCepInvalidoException e) {
            throw new RuntimeException("CEP inválido. O CEP deve conter 8 números.");
        }
    }
}
