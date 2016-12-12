package com.sync.sz.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class RequestDemo1 extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

  private void test2(HttpServletRequest req) {
    req.getHeader("");
  }

  /*
   * Request常用方法
   */
  private void test1(HttpServletRequest req) {
    System.out.println(req.getRequestURI());
    System.out.println(req.getRequestURL());
    System.out.println(req.getRemoteAddr());
    System.out.println(req.getRemotePort());
    System.out.println(req.getRemoteUser());
    System.out.println(req.getRemoteHost());
    System.out.println("---------------------------------");
    System.out.println(req.getLocalAddr());
    System.out.println(req.getLocalName());
    System.out.println(req.getLocalPort());
    System.out.println("-----------------------------------");
    System.out.println(req.getMethod());
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
