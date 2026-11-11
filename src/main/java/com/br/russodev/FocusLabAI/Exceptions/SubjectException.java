package com.br.russodev.FocusLabAI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SubjectException extends RuntimeException {
    public SubjectException(String message) {
        super(message);
    }
}
