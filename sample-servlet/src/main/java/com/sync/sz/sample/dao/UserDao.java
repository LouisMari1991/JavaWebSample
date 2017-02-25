package com.sync.sz.sample.dao;

import com.sync.sz.sample.domain.User;

/**
 * Created by Administrator on 2017/2/25 0025.
 */
public interface UserDao {
  void add(User user);

  User find(String username, String password);

  boolean find(String username);
}
