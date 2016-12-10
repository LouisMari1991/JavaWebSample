package com.sync.sz.web.servlet;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制浏览器定时刷新
 * Created by Administrator on 2016/12/10 0010.
 */
public class ResponseDemo3 extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    test3(req, resp);
  }

  /**
   * 实用的跳转技术
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  private void test3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String message = "<meta http-equiv='refresh' content='3;url=/jsp/index.jsp'>恭喜你，登录成功，将在三秒后跳转首页，如果没有跳，请点击<a href='/jsp/message.jsp'>超链接</a>";
    this.getServletContext().setAttribute("message", message);
    this.getServletContext().getRequestDispatcher("/jsp/message.jsp").forward(req, resp);
  }

  private void test2(HttpServletResponse resp) throws IOException {
    resp.setContentType("UTF-8");
    resp.setContentType("text/html;charset=UTF-8");
    resp.setHeader("refresh", "3;url='/jsp/index.jsp'");
    resp.getWriter().write("恭喜你，登录成功，将在三秒后跳转首页，如果没有跳，请点击<a href=''>超链接</a>");
  }

  private void test1(HttpServletResponse resp) throws IOException {
    resp.setHeader("refresh", "3");

    String data = new Random().nextInt(100000) + "";
    resp.getWriter().write(data);
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
