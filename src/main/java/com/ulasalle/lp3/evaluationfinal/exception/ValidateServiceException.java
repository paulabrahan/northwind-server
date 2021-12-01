package com.ulasalle.lp3.evaluationfinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ValidateServiceException extends RuntimeException {

  public ValidateServiceException() {
  }

  public ValidateServiceException(String s) {
    super(s);
  }

  public ValidateServiceException(String s, Throwable throwable) {
    super(s, throwable);
  }

  public ValidateServiceException(Throwable throwable) {
    super(throwable);
  }

  public ValidateServiceException(String s, Throwable throwable, boolean b, boolean b1) {
    super(s, throwable, b, b1);
  }
}
