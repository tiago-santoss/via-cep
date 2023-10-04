package br.com.api.cep.viacepapi.exception;

import java.io.Serial;
import java.text.MessageFormat;

public class NotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 7611290177859980627L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, null, enableSuppression, writableStackTrace);
    }

    public NotFoundException(String message, Object... param) {
        super(MessageFormat.format(message, param));
    }

    public NotFoundException(String message) {
        super(message);
    }
}
