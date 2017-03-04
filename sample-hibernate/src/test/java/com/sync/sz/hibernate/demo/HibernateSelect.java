package com.sync.sz.hibernate.demo;

import com.sync.sz.hibernate.entity.User;
import com.sync.sz.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class HibernateSelect {

  @Test
  public void testTx() {
    Session session = null;
    Transaction tx = null;
    try {
      session = HibernateUtils.getSessionObject();
      tx = session.beginTransaction();

      User user = new User();
      user.setUsername("小明");
      user.setPassword("as");
      user.setAddress("beijing");
      session.save(user);

      // 提交事务
      tx.commit();
    } catch (Exception e) {
      // 回滚事务
      tx.rollback();
    } finally {
      // 本地线程绑定的session不需要手动关闭
      //session.close();
    }
  }

  // 一级缓存特性
  @Test
  public void testDemo() {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    // 开启事务
    Transaction tx = session.beginTransaction();

    // 根据uid=4进行查询,第一次查询,发送sql语句查询数据库
    User user = session.get(User.class, 4);
    System.out.println(user);

    user.setUsername("ahahahahahhaha");

    //提交事务
    tx.commit();
    //关闭资源
    session.close();
    sessionFactory.close();
  }

  // 验证一级缓存存在
  @Test
  public void testCasch() {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    // 开启事务
    Transaction tx = session.beginTransaction();

    // 根据uid=4进行查询,第一次查询,发送sql语句查询数据库
    User user1 = session.get(User.class, 4);
    System.out.println(user1);

    // 第二次查询相同语句，不发送sql语句，查询一级缓存内容
    User user2 = session.get(User.class, 4);
    System.out.println(user2);

    //提交事务
    tx.commit();
    //关闭资源
    session.close();
    sessionFactory.close();
  }
}
