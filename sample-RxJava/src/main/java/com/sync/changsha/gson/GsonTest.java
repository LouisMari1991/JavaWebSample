package com.sync.changsha.gson;

import com.alibaba.fastjson.JSON;
import com.sync.changsha.Utils.GsonHelper;
import com.sync.changsha.gson.bean.MockBean;
import com.sync.sz.core.common.utils.JsonUtil;
import java.io.IOException;
import java.util.Map;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/5.
 */
public class GsonTest {

  @Test
  public void testCastObject() {

    //Map<String, Object> map = new HashMap<>();
    //map.put("name", "李四");
    //map.put("age", "18");
    //map.put("nick", "20");
    //map.put("phone", "18664569168");

    //String jsonStr = GsonHelper.object2JsonStr(map);

    //String jsonStr = "{\"nick\":\"20\",\"phone\":\"18664569168\",\"name\":\"李四\",\"age\":\"18\"}";
    //
    //System.out.println(jsonStr);
    //
    //Object o = GsonHelper.convertEntity(jsonStr, Object.class);
    //System.out.println(o);
    //
    //MockBean mockBean = (MockBean) o;
    //
    //System.out.println(mockBean);

    String json = "{   \"data\": {"
        + "        \"momeyTotal\": 0,"
        + "        \"volunteerTotal\": 0,"
        + "        \"volunteerMap\": null,"
        + "        \"gainTotal\": 0,"
        + "        \"activityTotal\": 0,"
        + "        \"publishTotal\": 0"
        + "    },"
        + "    \"msg\": \"\","
        + "    \"pages\": 0,"
        + "    \"status\": 200,"
        + "    \"total\": 0"
        + "}";

    System.out.println(json);

    System.out.println(JSON.parseObject(json));

    Map map = GsonHelper.convertEntity(json,Map.class);

    System.out.println(map);

    System.out.println(map.get("volunteerMap"));
  }

  public static void main(String[] args) {
    String jsonStr = "{\"nick\":\"20\",\"phone\":\"18664569168\",\"name\":\"李四\",\"age\":\"18\"}";

    System.out.println(jsonStr);

    Object o = GsonHelper.convertEntity(jsonStr, Object.class);
    System.out.println(o);

    MockBean mockBean = (MockBean) o;

    System.out.println(mockBean);
  }

  @Test
  public void jacksonTest() {
    String jsonStr = "{\"nick\":\"20\",\"phone\":\"18664569168\",\"name\":\"李四\",\"age\":\"18\"}";
    try {
      Object o = JsonUtil.jsonToObject(jsonStr);
      System.out.printf(o.toString());

      MockBean mockBean = (MockBean) o;

      System.out.println(mockBean);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
