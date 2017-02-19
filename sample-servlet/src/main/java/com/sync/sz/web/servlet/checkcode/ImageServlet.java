package com.sync.sz.web.servlet.checkcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YH on 2017-02-19.
 */
public class ImageServlet extends HttpServlet {

  public static final int WIDTH = 120;
  public static final int HEIGHT = 35;

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {

    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);

    Graphics g = image.getGraphics();

    // 设置背景色
    setBackGround(g);

    // 设置边框
    setBorder(g);

    // 画干扰线
    drawRandomLine(g);

    // 写随机数
    String random = drawRandomNum((Graphics2D) g);

    req.getSession().setAttribute("checkcode", random);

    // 写图形给浏览器
    resp.setContentType("image/jpeg");

    // 发头控制浏览器不要缓存
    resp.setDateHeader("expires", -1);
    resp.setHeader("Cache-Control", "no-cache");
    resp.setHeader("Pragma", "no-cache");

    ImageIO.write(image, "jpg", resp.getOutputStream());
  }

  private String drawRandomNum(Graphics2D g) {
    g.setColor(Color.RED);
    g.setFont(new Font("宋体", Font.BOLD, 20));
    String base = "\u7684\u4e86\u6211\u5728";

    StringBuffer sb = new StringBuffer();

    int x = 10;
    for (int i = 0; i < 4; i++) {
      String ch = base.charAt(i) + "";
      sb.append(ch);
      int degree = new Random().nextInt() % 30;
      g.rotate(degree * Math.PI / 180, x, 20); // 设置旋转幅度
      g.drawString(ch, x, 20);
      g.rotate(-degree * Math.PI / 180, x, 20);// 旋转回来
      x += 30;
    }
    return sb.toString();
  }

  private void drawRandomLine(Graphics g) {
    g.setColor(Color.GREEN);
    for (int i = 0; i < 5; i++) {
      int x1 = new Random().nextInt(WIDTH);
      int y1 = new Random().nextInt(HEIGHT);
      int x2 = new Random().nextInt(WIDTH);
      int y2 = new Random().nextInt(HEIGHT);
      g.drawLine(x1, y1, x2, y2);
    }
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doGet(req, resp);
  }

  public void setBackGround(Graphics backGround) {
    backGround.setColor(Color.WHITE);
    backGround.fillRect(0, 0, WIDTH, HEIGHT);
  }

  public void setBorder(Graphics border) {
    border.setColor(Color.BLUE);
    border.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
  }
}
