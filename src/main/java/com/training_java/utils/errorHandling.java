package com.training_java.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class errorHandling extends RuntimeException {
    public errorHandling(HttpStatus notFound, String message) {
        super(message);
    }
}
