package com.sync.changsha.gson.bean;

/**
 * Created by Administrator on 2017/12/7.
 */
public class MapBeanWrapper {

  private int status;
  private String msg;
  private long total;
  private int pages;
  private MapBean data;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public MapBean getData() {
    return data;
  }

  public void setData(MapBean data) {
    this.data = data;
  }

  @Override public String toString() {
    return "MapBeanWrapper{" +
        "status=" + status +
        ", msg='" + msg + '\'' +
        ", total=" + total +
        ", pages=" + pages +
        ", data=" + data +
        '}';
  }
}
