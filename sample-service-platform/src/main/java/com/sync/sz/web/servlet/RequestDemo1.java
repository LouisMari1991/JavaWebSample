package com.sync.sz.web.servlet;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class RequestDemo1 extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    test3(req, resp);
  }

  /**
   * 请求转发
   * 特点：
   * 1、客服端只发送一次请求，而服务器端有多个资源调用
   * 2、客服端浏览地址栏没有变化
   */
  private void test3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String data = "aaabbbccc";
    req.setAttribute("data",data);
    req.getRequestDispatcher("/jsp/message.jsp").forward(req, resp);
  }

  /**
   * 获取请求头相关的方法
   * @param req
   */
  private void test2(HttpServletRequest req) {
    Enumeration enumeration = req.getHeaderNames();
    while (enumeration.hasMoreElements()) {
      String name = (String) enumeration.nextElement();
      String value = req.getHeader(name);
      System.out.println(name + "=" + value);
    }
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
    String username = req.getParameter("username");
    System.out.println(username);
  }
}
