package com.sync.changsha.gson;

import com.sync.changsha.Utils.GsonHelper;
import com.sync.changsha.gson.bean.MockBean;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/5.
 */
public class GsonTest {

  public void testCastObject() {

    //Map<String, Object> map = new HashMap<>();
    //map.put("name", "李四");
    //map.put("age", "18");
    //map.put("nick", "20");
    //map.put("phone", "18664569168");

    //String jsonStr = GsonHelper.object2JsonStr(map);

    String jsonStr = "{\"nick\":\"20\",\"phone\":\"18664569168\",\"name\":\"李四\",\"age\":\"18\"}";

    System.out.println(jsonStr);

    Object o = GsonHelper.convertEntity(jsonStr, Object.class);
    System.out.println(o);

    MockBean mockBean = (MockBean) o;

    System.out.println(mockBean);
  }

  public static void main(String[] args) {
    String jsonStr = "{\"nick\":\"20\",\"phone\":\"18664569168\",\"name\":\"李四\",\"age\":\"18\"}";

    System.out.println(jsonStr);

    Object o = GsonHelper.convertEntity(jsonStr, Object.class);
    System.out.println(o);

    MockBean mockBean = (MockBean) o;

    System.out.println(mockBean);
  }

}
