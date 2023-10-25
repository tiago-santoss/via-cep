package br.com.api.cep.viacepapi.integration;

import br.com.api.cep.viacepapi.exception.FormatCepInvalidException;
import br.com.api.cep.viacepapi.models.CepResponseRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepFeignIntegration {

    @GetMapping("/{cep}/json/")
    CepResponseRepresentation searchCep(@RequestParam("cep") String cep) throws FormatCepInvalidException;
}


