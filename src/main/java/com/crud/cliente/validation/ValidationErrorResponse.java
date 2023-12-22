package com.crud.cliente.validation;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationErrorResponse {
    private int status;
    private String message;
    private List<String> errorMessages;

    public ValidationErrorResponse(int status, String message, List<String> errorMessages) {
        this.status = status;
        this.message = message;
        this.errorMessages = errorMessages;
    }

}
