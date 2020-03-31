package com.motus.assosuite.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private String resourceName;

    public NotFoundException(String resourceName) {
        super(String.format("The %s not found", resourceName));
    }
}
