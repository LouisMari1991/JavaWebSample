package com.sync.sz.web.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 代表网站首页
 */
public class CookieDemo1 extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=UTF-8");

    PrintWriter out = resp.getWriter();
    out.print("您上次访问时间是:");

    Cookie[] cookies = req.getCookies();
    for (int i = 0; cookies != null && i < cookies.length; i++) {
      if (cookies[i].getName().equals("lastAccessTime")) {
        Long cookieValue = Long.valueOf(cookies[i].getValue());
        Date date = new Date(cookieValue);
        out.print(date.toLocaleString());
      }
    }

    Cookie cookie = new Cookie("lastAccessTime", String.valueOf(System.currentTimeMillis()));
    cookie.setMaxAge(30 * 24 * 3600);
    cookie.setPath("/");

    resp.addCookie(cookie);
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
