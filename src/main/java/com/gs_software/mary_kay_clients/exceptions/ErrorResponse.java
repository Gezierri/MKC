package com.gs_software.mary_kay_clients.exceptions;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private String messageException;
    private int status;
}
