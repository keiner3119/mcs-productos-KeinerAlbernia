package com.main.application.utilities;

import org.springframework.http.HttpStatus;

public class ResponseGenericDto {
    public Boolean state;
    public String message;
    public HttpStatus httpStatus;
}