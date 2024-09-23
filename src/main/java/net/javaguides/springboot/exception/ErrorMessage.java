package net.javaguides.springboot.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
  private int statusCode;
  private String title;
  private String detail;

  public ErrorMessage(BusinessException businessException){
    this.statusCode  = businessException.getStatusCode();
    this.title = businessException.getTitle();
    this.detail = businessException.getDetail();
  }
}
