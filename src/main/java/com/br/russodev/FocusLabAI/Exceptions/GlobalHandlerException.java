package com.br.russodev.FocusLabAI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(SubjectException.class)
    public ResponseEntity<RestErrorMessage> subjectErrorHandler(SubjectException subjectException){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, subjectException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restErrorMessage);
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity<RestErrorMessage> subjectErrorHandler(SubjectNotFoundException subjectNotFoundException){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, subjectNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestErrorMessage> methodArgumentNotValidHandler(MethodArgumentNotValidException methodArgumentNotValidException){
        FieldError erro = methodArgumentNotValidException
                .getBindingResult()
                .getFieldError();
        String message = erro != null
                ? erro.getDefaultMessage()
                : "Invalid data";
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restErrorMessage);
    }

    @ExceptionHandler(StudySessionNotFoundException.class)
    public ResponseEntity<RestErrorMessage> studySessionNotFoudHandler(StudySessionNotFoundException studySessionNotFoundException){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, studySessionNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @ExceptionHandler(StudySessionException.class)
    public ResponseEntity<RestErrorMessage> studySessionHandler(StudySessionException studySessionException){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, studySessionException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restErrorMessage);
    }


}
