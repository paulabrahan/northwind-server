package com.ulasalle.lp3.evaluationfinal.exception;

import com.ulasalle.lp3.evaluationfinal.constant.ControllerConstant;
import com.ulasalle.lp3.evaluationfinal.model.WrapperResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> all(Exception e, WebRequest request) {
        log.error("[ErrorHandler]: all() ==> ", e);
        WrapperResponse<?> response = new WrapperResponse<>(ControllerConstant.ERROR_MESSAGE, null, false);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> noDataFoundException(NoDataFoundException e, WebRequest request) {
        log.info("[ErrorHandler]: noDataFoundException() ==> ", e);
        WrapperResponse<?> response = new WrapperResponse<>(e.getMessage(), null, false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateServiceException.class)
    public ResponseEntity<Object> noValidationException(ValidateServiceException e, WebRequest request) {
        log.info("[ErrorHandler]: noValidationException() ==> ", e);
        WrapperResponse<?> response = new WrapperResponse<>(e.getMessage(), null, false);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }





}
