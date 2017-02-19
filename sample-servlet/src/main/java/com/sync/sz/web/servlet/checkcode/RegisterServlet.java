package com.sync.sz.web.servlet.checkcode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YH on 2017-02-19.
 */
public class RegisterServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    // 校验验证码是否有效
    String c_checkcode = req.getParameter("checkcode");
    String s_checkcode = (String) req.getSession().getAttribute("checkcode");
    if (c_checkcode != null && s_checkcode != null && c_checkcode.equals(s_checkcode)) {
      System.out.println("处理注册请求");
    } else {
      System.out.println("验证码错误");
    }
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }
}
