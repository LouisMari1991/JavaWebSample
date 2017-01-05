package com.sync.sz.netty.protocol.http.xml;

import java.util.ArrayList;

/**
 * Created by YH on 2017-01-05.
 */
public class OrderFactory {
  public static Order create(long orderID) {
    Order order = new Order();
    order.setOrderNumber(orderID);
    order.setTotal(9999.999f);
    Address address = new Address();
    address.setCity("sz");
    address.setCountry("China");
    address.setPostCode("123321");
    address.setState("hunan");
    address.setStreet1("xiangtan");
    order.setBillTo(address);
    Customer customer = new Customer();
    customer.setCustomerNumber(orderID);
    customer.setFirstName("mari");
    customer.setLastName("sync");
    customer.setMiddleNames(new ArrayList<String>() {
      {
        add("XN");
        add("XY");
        add("YT");
      }
    });
    order.setCustomer(customer);
    order.setShipping(Shipping.INTERNATIONAL_MAIL);
    order.setShipTo(address);
    return order;
  }
}
