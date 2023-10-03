package br.com.api.cep.viacepapi.service;

import br.com.api.cep.viacepapi.client.ViaCepFeignClient;
import br.com.api.cep.viacepapi.models.CepResponseRepresentation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViaCepService {


    private final ViaCepFeignClient feignClient;

    public CepResponseRepresentation searchCep(String cep){
        return feignClient.searchCep(cep);
    }

}
