package com.devspringboot.accounts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName, String filedName, String fieldValue){
        super(String.format("%s not found with the given input data %s: '%s'", resourceName, filedName, fieldValue));
    }
}
