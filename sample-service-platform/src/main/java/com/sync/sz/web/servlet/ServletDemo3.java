package com.sync.sz.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  servletContext域：
 1.这是一个容器
 2.servletContext域这句话说明了这个容器的作用范围，也就是应用程序范围
 */

// 通过servletContext实现ServletDemo3和ServletDemo4的数据共享
public class ServletDemo3 extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String data = "aa";
    this.getServletContext().setAttribute("aa", data);
    System.out.println("demo3 get end");
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}
