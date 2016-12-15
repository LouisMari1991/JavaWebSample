package com.sync.sz.web.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
public class CookieDemo3 extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    String id = req.getParameter("id");
    Book book = Db.getAll().get(id);
    out.write(book.getId() + "<br/>");
    out.write(book.getAuthor() + "<br/>");
    out.write(book.getName() + "<br/>");
    out.write(book.getDescription() + "<br/>");

    String cookieValue = buildCookie(id, req);
    Cookie cookie = new Cookie("bookHistory", cookieValue);
    cookie.setMaxAge(30 * 24 * 60 * 60);
    cookie.setPath("/");
    resp.addCookie(cookie);
  }

  private String buildCookie(String id, HttpServletRequest req) {

    String bookHistory = null;
    Cookie[] cookies = req.getCookies();
    for (int i = 0; cookies != null && i < cookies.length; i++) {
      if (cookies[i].getName().equals("bookHistory")) {
        bookHistory = cookies[i].getValue();
      }
    }

    if (bookHistory == null) {
      return id;
    }
    LinkedList<String> list = new LinkedList(Arrays.asList(bookHistory.split("\\,")));
    if (list.contains(id)) {
      list.remove(id);
    } else {
      if (list.size() >= 3) {
        list.removeLast();
      }
    }
    list.addFirst(id);

    StringBuffer sb = new StringBuffer();
    for (String bid : list) {
      sb.append(bid).append(",");
    }
    return sb.deleteCharAt(sb.length() - 1).toString();
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
