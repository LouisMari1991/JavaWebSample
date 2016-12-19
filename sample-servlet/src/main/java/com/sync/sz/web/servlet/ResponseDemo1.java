package com.sync.sz.web.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/10 0010.
 */
public class ResponseDemo1 extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    test4(req, resp);
  }

  private void test4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //req.setCharacterEncoding("UTF-8");
    // 设置response使用的码表,以控制response以什么码表向浏览器写数据
    //resp.setCharacterEncoding("UTF-8");
    // 指定浏览器以什么码表的打开服务器发送的数据
    //resp.setHeader("content-type","text/html;charset=UTF-8");
    resp.setContentType("text/html;charset=UTF-8");
    String data = "中国";
    PrintWriter out = resp.getWriter();

    out.write(data);
    out.close();
  }

  private void test3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");

    String data = "中国";
    OutputStream out = resp.getOutputStream();

    out.write(data.getBytes("UTF-8"));
    out.close();
  }

  private void test2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String data = "中国";
    OutputStream out = resp.getOutputStream();

    out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
    out.write(data.getBytes("UTF-8"));
    out.close();
  }

  private void test1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setHeader("Content-type", "text/html;charset=UTF-8");
    String data = "中国";
    OutputStream out = resp.getOutputStream();
    out.write(data.getBytes("UTF-8"));
    out.close();
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}
