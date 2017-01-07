package com.sync.sz.netty.protocol.http.xml.pojo;


public class OrderFactory {

  public static Order create(long orderID) {
    Order order = new Order();
    order.setOrderNumber(orderID);
    order.setTotal(9999.999f);
    Address address = new Address();
    address.setCity("sz");
    address.setCountry("china");
    address.setPostCode("123321");
    address.setState("gdsgeng");
    address.setStreet1("baoanqu");
    order.setBillTo(address);
    Customer customer = new Customer();
    customer.setCustomerNumber(orderID);
    customer.setFirstName("mari");
    customer.setLastName("sync");
    order.setCustomer(customer);
    order.setShipTo(address);
    return order;
  }
}
