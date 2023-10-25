package br.com.api.cep.viacepapi.exception;

public class FormatCepInvalidException extends RuntimeException {

    public FormatCepInvalidException(String message, String cep) {
        super(message);
    }


}
