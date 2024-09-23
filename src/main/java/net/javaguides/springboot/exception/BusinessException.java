package net.javaguides.springboot.exception;


public class BusinessException extends RuntimeException {
  private int statusCode;
  private String title;
  private String detail;

  public BusinessException(int statusCode, String title, String detail) {
    this.statusCode = statusCode;
    this.title = title;
    this.detail = detail;
  }

  public int getStatusCode(){
    return statusCode;
  }

  public String getTitle(){
    return title;
  }
  
  public String getDetail(){
    return detail;
  }
}
