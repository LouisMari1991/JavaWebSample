package com.sync.sz.web.servlet.form;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/25 0025.
 */
public class DoFormServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //String username = req.getParameter("username");
    //System.out.println("注册用户 :" + username);

    boolean b = isTokenValid(req);
    if (!b) {
      System.out.println("请不要重复提交表单");
      return;
    }

    req.getSession().removeAttribute("token");
    System.out.println("处理表单提交 --->");
  }

  // 判断表单号是否有效
  private boolean isTokenValid(HttpServletRequest req) {

    String client_token = req.getParameter("token");

    if (client_token == null) {
      return false;
    }

    String server_token = (String) req.getSession().getAttribute("token");

    if (server_token == null) {
      return false;
    }

    if (!server_token.equals(client_token)) {
      return false;
    }

    return true;
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
