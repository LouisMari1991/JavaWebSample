package com.sync.sz.hibernate.demo;

import com.sync.sz.hibernate.entity.User;
import com.sync.sz.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by Administrator on 2017/2/28 0028.
 */
public class HibernateDemo {

  @Test
  public void testAdd() {
    Configuration cfg = new Configuration();
    cfg.configure();

    //SessionFactory sessionFactory = cfg.buildSessionFactory();

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    // 创建session对象,类似于连接
    Session session = sessionFactory.openSession();

    // 开启事物
    Transaction tx = session.beginTransaction();

    User user = new User();
    user.setUsername("小名");
    user.setPassword("aaa123");
    user.setAddress("shenzhen");

    // 添加
    session.save(user);

    // 提交事物
    tx.commit();

    // 关闭资源
    session.close();
    sessionFactory.close();
  }
}
