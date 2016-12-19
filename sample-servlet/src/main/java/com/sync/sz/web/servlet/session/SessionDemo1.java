package com.sync.sz.web.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class SessionDemo1 extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Cookie的形式或者超链接的形式,都没有就创建Session
    HttpSession session = req.getSession();
    String sessionId = session.getId();
    Cookie cookie = new Cookie("JSESSIONID", sessionId);
    cookie.setMaxAge(30 * 60);
    session.setAttribute("name", "Java Web");
    resp.addCookie(cookie);
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
