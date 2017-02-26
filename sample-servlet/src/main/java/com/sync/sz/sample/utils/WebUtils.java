package com.sync.sz.sample.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class WebUtils {

  public static <T> T request2Bean(HttpServletRequest rep, Class<T> beanClass) {
    try {
      T bean = beanClass.newInstance();

      Enumeration<String> e = rep.getParameterNames();
      while (e.hasMoreElements()) {
        String name = e.nextElement();
        String value = rep.getParameter(name);
        BeanUtils.setProperty(bean, name, value);
      }
      return bean;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void copyBean(Object src, Object dest) {
    ConvertUtils.register(new Converter() {
      @Override public <T> T convert(Class<T> aClass, Object o) {
        if (o == null) {
          return null;
        }
        String str = (String) o;
        if (str.trim().equals("")) {
          return null;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
          return (T) df.parse(str);
        } catch (ParseException e) {
          throw new RuntimeException(e);
        }
      }
    }, Date.class);

    try {
      BeanUtils.copyProperties(dest, src);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static String generateID() {
    return UUID.randomUUID().toString();
  }
}
