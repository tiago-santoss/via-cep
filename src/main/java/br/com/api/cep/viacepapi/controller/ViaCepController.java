package br.com.api.cep.viacepapi.controller;

import br.com.api.cep.viacepapi.apis.CepApiDelegate;
import br.com.api.cep.viacepapi.models.CepResponseRepresentation;
import br.com.api.cep.viacepapi.service.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ViaCepController implements CepApiDelegate {

    private final ViaCepService service;

    @Override
    public ResponseEntity<CepResponseRepresentation> searchCep(String cep) {
        var response = service.searchCep(cep);
        return ResponseEntity.ok(response);
    }
}
