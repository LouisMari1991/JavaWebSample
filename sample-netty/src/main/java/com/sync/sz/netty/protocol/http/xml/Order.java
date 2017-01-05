package com.sync.sz.netty.protocol.http.xml;

/**
 * Created by YH on 2017-01-05.
 */
public class Order {

  private long orderNumber;

  private Float total;

  private Customer customer;

  private Shipping shipping;

  private Address billTo;

  private Address shipTo;

  public long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Float getTotal() {
    return total;
  }

  public void setTotal(Float total) {
    this.total = total;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Shipping getShipping() {
    return shipping;
  }

  public void setShipping(Shipping shipping) {
    this.shipping = shipping;
  }

  public Address getBillTo() {
    return billTo;
  }

  public void setBillTo(Address billTo) {
    this.billTo = billTo;
  }

  public Address getShipTo() {
    return shipTo;
  }

  public void setShipTo(Address shipTo) {
    this.shipTo = shipTo;
  }

  @Override public String toString() {
    return "Order{" +
        "orderNumber=" + orderNumber +
        ", total=" + total +
        ", customer=" + customer +
        ", shipping=" + shipping +
        ", billTo=" + billTo +
        ", shipTo=" + shipTo +
        '}';
  }
}
