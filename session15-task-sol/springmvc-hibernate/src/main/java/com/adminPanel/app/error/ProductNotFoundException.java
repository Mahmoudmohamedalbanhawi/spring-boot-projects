package com.adminPanel.app.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter

public class ProductNotFoundException extends ApiException {
    public ProductNotFoundException(String msg)
    {
        super(msg , HttpStatus.NOT_FOUND);
    }

}
