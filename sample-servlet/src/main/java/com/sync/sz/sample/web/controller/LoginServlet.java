package com.sync.sz.sample.web.controller;

import com.sync.sz.sample.domain.User;
import com.sync.sz.sample.service.BusinessService;
import com.sync.sz.sample.service.impl.BusinessServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class LoginServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    BusinessService service = new BusinessServiceImpl();
    User user = service.login(username, password);
    if (user != null) {
      req.getSession().setAttribute("user", user);
      // 登录成功,跳转首页
      resp.sendRedirect("/sample/index.jsp");
    } else {
      req.setAttribute("message", "用户名或密码错误!!");
      req.getRequestDispatcher("/sample/message.jsp").forward(req, resp);
    }
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
