package com.sync.changsha.gson.bean;

/**
 * <pre>
 *     desc   : TO-DO
 *     author : 罗顺翔
 *     time   : 2017-06-08 14:13
 *     version: 1.0
 * </pre>
 */

public class ResultResponse<T> {

  public int status;
  public String msg;
  public long total;
  public int pages;

  public T data;

  @Override public String toString() {
    return "ResultResponse{"
        + "status="
        + status
        + ", msg='"
        + msg
        + '\''
        + ", total="
        + total
        + ", pages="
        + pages
        + ", data="
        + data
        + '}';
  }
}
