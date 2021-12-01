package com.ulasalle.lp3.evaluationfinal.model;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WrapperResponse<T> {

    private String message;
    private T data;
    private boolean status;

    public ResponseEntity<WrapperResponse<T>> createResponse(HttpStatus httpStatus) {
        return new ResponseEntity<>(this, httpStatus);
    }

}
