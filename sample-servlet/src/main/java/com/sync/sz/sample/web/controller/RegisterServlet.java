package com.sync.sz.sample.web.controller;

import com.sync.sz.sample.domain.User;
import com.sync.sz.sample.exception.UserExistException;
import com.sync.sz.sample.form.RegisterForm;
import com.sync.sz.sample.service.BusinessService;
import com.sync.sz.sample.service.impl.BusinessServiceImpl;
import com.sync.sz.sample.utils.WebUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/2/25 0025.
 */
public class RegisterServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RegisterForm form = WebUtils.request2Bean(req, RegisterForm.class);
    System.out.println(form.getNickname());
    boolean b = form.validate();
    // 检验失败，跳回登录页面
    if (!b) {
      req.setAttribute("form", form);
      req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
      return;
    }

    // 检验成功，调用service处理注册请求
    User user = new User();
    user.setId(WebUtils.generateID());
    WebUtils.copyBean(form, user);

    BusinessService service = new BusinessServiceImpl();
    try {
      service.regiester(user);
      // 注册成功
      req.setAttribute("message", "恭喜您,注册成功!!");
      req.getRequestDispatcher("/sample/message.jsp").forward(req, resp);
      return;
    } catch (UserExistException e) {
      form.getErrors().put("username", "注册的用户名已存在!!");
      req.setAttribute("form", form);
      req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
      return;
    } catch (Exception e) {
      req.setAttribute("message", "服务器出现未知错误!!!");
      req.getRequestDispatcher("/sample/message.jsp").forward(req, resp);
      return;
    }
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
