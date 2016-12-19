package com.sync.sz.web.servlet.shopping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
public class BuyServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    Book book = Db.getAll().get(id);
    HttpSession session = req.getSession(false);
    // 手动以Cookie发session Id,以解决关闭浏览器后，上次买的东西还在
    //Cookie cookie = new Cookie("JSESSIONID", session.getId());
    //cookie.setMaxAge(30 * 60);
    List<Book> list = (List<Book>) session.getAttribute("list");
    if (list == null) {
      list = new ArrayList<>();
      session.setAttribute("list", list);
    }
    list.add(book);

    //resp.addCookie(cookie);

    String url = resp.encodeRedirectURL(req.getContextPath() + "/ListCartServlet");

    resp.sendRedirect(url);
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
