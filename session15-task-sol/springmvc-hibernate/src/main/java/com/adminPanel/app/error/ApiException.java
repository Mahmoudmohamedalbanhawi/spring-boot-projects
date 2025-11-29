package com.adminPanel.app.error;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{
    private final HttpStatus status;
    public ApiException(String msg , HttpStatus status)
    {
        super(msg);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
