package com.sync.sz.web.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/3 0003.
 */
public class ServletDemo1 extends HttpServlet{

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //Enumeration enumeration =  req.getHeaderNames();
    //
    //while (enumeration.hasMoreElements()) {
    //  System.out.println(enumeration.nextElement() + " : " + req.getHeader(enumeration.nextElement().toString()));
    //}

    test3(resp);

  }

  /**
   * 定时刷新浏览器:refresh
   * @param resp
   * @throws IOException
   */
  private void test3(HttpServletResponse resp) throws IOException {
    resp.setHeader("refresh", "3;url='http://www.baidu.com'");

    String data = "aaaaaaaa";
    resp.getWriter().write(data);
  }


  /**
   * 压缩数据输出
   * @param req
   * @param resp
   * @throws IOException
   */
  private void test2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String str = "aanabbaaccaaaaavvvvaaantyuaa";
    for (int i = 0; i < 5; i++) {
      str += str;
    }
    System.out.println("原来的大小:"+str.getBytes().length);

    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    GZIPOutputStream gout = new GZIPOutputStream(bout);
    gout.write(str.getBytes());
    gout.close();

    byte gzip[] = bout.toByteArray();
    System.out.println("压缩后的数据大小:"+gzip.length);

    resp.setHeader("Content-Encoding", "gzip");
    resp.setHeader("Content-Length", String.valueOf(gzip.length));
    resp.getOutputStream().write(gzip);
  }

  /**
   * 重定向
   * @param resp
   */
  private void test1(HttpServletResponse resp){

    resp.setStatus(302);
    resp.setHeader("location", "http://www.baidu.com");
  }


  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}
