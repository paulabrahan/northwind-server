package com.ulasalle.lp3.evaluationfinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class NoDataFoundException extends RuntimeException {

  public NoDataFoundException() {
  }

  public NoDataFoundException(String s) {
    super(s);
  }

  public NoDataFoundException(String s, Throwable throwable) {
    super(s, throwable);
  }

  public NoDataFoundException(Throwable throwable) {
    super(throwable);
  }

  public NoDataFoundException(String s, Throwable throwable, boolean b, boolean b1) {
    super(s, throwable, b, b1);
  }
}
