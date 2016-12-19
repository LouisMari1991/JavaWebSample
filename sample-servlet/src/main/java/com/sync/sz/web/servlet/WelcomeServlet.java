package com.sync.sz.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
public class WelcomeServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    req.getSession();

    // url重写，自动在url后面加上session id号，如果浏览器没有禁用Cookie则不会加上session id
    String url1 = resp.encodeURL("/SessionDemo1");
    String url2 = resp.encodeURL("/SessionDemo2");

    System.out.println(url1 + ", " + url2);

    out.print("<a href='" + url1 + "'>购买</a><br/>");
    out.print("<a href='" + url2 + "'>结账</a>");
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
