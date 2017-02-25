package com.sync.sz.sample.service;

import com.sync.sz.sample.domain.User;
import com.sync.sz.sample.exception.UserExistException;

/**
 * Created by Administrator on 2017/2/25 0025.
 */
public interface BusinessService {
  void regiester(User user) throws UserExistException;

  User login(String username, String password);
}
