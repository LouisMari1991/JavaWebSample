package com.sync.sz.web.servlet.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
public class ListCartServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    HttpSession session = req.getSession(false);
    if (session == null) {
      out.write("您没有购买任何商品!!!");
      return;
    }
    out.write("您购买了如下商品:<br/>");
    List<Book> list = (List<Book>) session.getAttribute("list");
    for (Book book : list) {
      out.write(book.getName() + "<br/>");
    }
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
