package com.sync.sz.sample.exception;

/**
 * Created by Administrator on 2017/2/25 0025.
 */
public class UserExistException extends Exception {

  public UserExistException() {
  }

  public UserExistException(String message) {
    super(message);
  }

  public UserExistException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserExistException(Throwable cause) {
    super(cause);
  }
}
