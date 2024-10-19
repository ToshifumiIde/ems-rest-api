package net.javaguides.springboot.controller.common;

import net.javaguides.springboot.exception.BusinessException;
import net.javaguides.springboot.exception.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorMessage> handleBusinessException(BusinessException e) {
    ErrorMessage errorMessage = new ErrorMessage(e);
    return ResponseEntity.status(errorMessage.getStatusCode()).body(errorMessage);
  }
}
