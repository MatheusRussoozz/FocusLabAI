package com.br.russodev.FocusLabAI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudySessionNotFoundException extends RuntimeException {

    public StudySessionNotFoundException(){ super ("Study Session not foud");}

    public StudySessionNotFoundException(String message) {
        super(message);
    }
}
