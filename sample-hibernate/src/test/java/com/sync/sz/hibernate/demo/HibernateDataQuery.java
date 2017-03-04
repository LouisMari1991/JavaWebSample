package com.sync.sz.hibernate.demo;

import com.sync.sz.hibernate.entity.User;
import com.sync.sz.hibernate.utils.HibernateUtils;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class HibernateDataQuery {

  @Test
  public void testSQLQuery() {
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    try {
      sessionFactory = HibernateUtils.getSessionFactory();
      session = sessionFactory.openSession();
      tx = session.beginTransaction();

      // 使用普通sql语句
      SQLQuery sqlQuery = session.createSQLQuery("SELECT  * FROM t_user ");
      // 下面之中方法也行
      //List<User> list = sqlQuery.list();
      //for (User user : list) {
      //  System.out.println(user);
      //}
      // 返回list集合，默认里面每部分数组结构
      //List<Object[]> list = sqlQuery.list();
      //for (Object[] objects : list) {
      //  System.out.println(Arrays.toString(objects));
      //}

      // 返回的list的每部分是对象形式， 设置数据封装到类中
      sqlQuery.addEntity(User.class);

      List<User> list = sqlQuery.list();
      for (User user : list) {
        System.out.println(user);
      }
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  @Test
  public void testCriteria() {
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    try {
      sessionFactory = HibernateUtils.getSessionFactory();
      session = sessionFactory.openSession();
      tx = session.beginTransaction();

      // 创建Criteria对象
      Criteria criteria = session.createCriteria(User.class);
      List<User> list = criteria.list();
      for (User user : list) {
        System.out.println(user);
      }

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  @Test
  public void testQuery() {
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    try {
      sessionFactory = HibernateUtils.getSessionFactory();
      session = sessionFactory.openSession();
      tx = session.beginTransaction();

      // 创建Query对象
      Query query = session.createQuery("from User");
      List<User> list = query.list();
      for (User user : list) {
        System.out.println(user);
      }
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      session.close();
      sessionFactory.close();
    }
  }
}
