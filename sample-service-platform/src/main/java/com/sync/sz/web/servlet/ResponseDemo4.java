package com.sync.sz.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
请求重定向的特点:
 1.浏览器会向服务器发送两次请求,意味着就有2个 request/response.
 2.重定向技术,浏览器地址栏会发生变化.

 用户登录和显示购物车时,通常会用到重定向技术.

 */
public class ResponseDemo4 extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect("/jsp/index.jsp");
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
