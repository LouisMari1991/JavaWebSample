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

  @Test
  public void testGet() {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();

    // 开启事物
    Transaction tx = session.beginTransaction();

    // 根据id查询, 没有查询到时返回: null
    User user = session.get(User.class, 7);

    System.out.println("------------------------------- >>> user : " + user);

    //提交事物
    tx.commit();

    //关闭资源
    session.close();
    sessionFactory.close();
  }

  @Test
  public void testUpdate() {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    // 开启事物
    Transaction tx = session.beginTransaction();

    // 根据id查询
    User user = session.get(User.class, 7);
    user.setUsername("嘿嘿嘿");
    user.setPassword("4654654654");
    user.setAddress("北京");

    // 调用session update方法修改, save使用效果一样，但是违反原则
    session.update(user);

    //提交事物
    tx.commit();
    //关闭资源
    session.close();
    sessionFactory.close();
  }

  @Test
  public void testDelete() {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    // 开启事物
    Transaction tx = session.beginTransaction();

    // 删除操作，调用delete方法

    // 根据id查询对象,再删除数据
    User user = session.get(User.class, 3);
    session.delete(user);

    //提交事物
    tx.commit();
    //关闭资源
    session.close();
    sessionFactory.close();
  }


  @Test
  public void testSaveOrUpdate() {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    // 开启事物
    Transaction tx = session.beginTransaction();

    // saveOrUpdate 方法
    // 实体类对象是瞬时态,做添加操作 insert
    // 实体类对象是托管态,做修改操作 update
    // 实体类对象是持久态,做修改操作 update
    User user = new User();
    user.setUid(100);
    user.setUsername("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    user.setPassword("asdasd");

    session.saveOrUpdate(user);

    //提交事物
    tx.commit();
    //关闭资源
    session.close();
    sessionFactory.close();
  }
}
