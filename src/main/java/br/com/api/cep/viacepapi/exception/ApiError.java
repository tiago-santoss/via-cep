package br.com.api.cep.viacepapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class ApiError {

    private String timestamp = LocalDateTime.now(ZoneOffset.UTC).toString();
    private List<String> errors;

    public ApiError(List<String> errors) {
        this.errors = errors;
    }

}
