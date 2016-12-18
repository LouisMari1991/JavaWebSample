package com.sync.sz.web.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
public class LoginServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    String username = req.getParameter("username");
    String password = req.getParameter("password");
    List<User> list = DB.getAll();
    for (User user : list) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("/jsp/index.jsp");
        return;
      }
    }
    out.write("用户名或者密码不正确!!!");
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}

class DB {

  public static List<User> getAll() {
    return list;
  }

  private static List<User> list = new ArrayList<User>();

  static {
    list.add(new User("aaa", "aaa"));
    list.add(new User("bbb", "bbb"));
    list.add(new User("ccc", "ccc"));
    list.add(new User("ddd", "ddd"));
  }
}
