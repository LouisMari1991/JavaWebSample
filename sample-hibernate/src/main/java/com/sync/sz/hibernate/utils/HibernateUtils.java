package com.sync.sz.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Administrator on 2017/2/28 0028.
 */
public class HibernateUtils {

  private final static Configuration cfg;
  private final static SessionFactory sessionFactory;

  static {
    // 加载核心配置文件
    cfg = new Configuration().configure();
    cfg.configure();
    sessionFactory = cfg.buildSessionFactory();
  }

  // 返回与本地线程绑定的session方法
  public static Session getSessionObject() {
    return sessionFactory.getCurrentSession();
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
