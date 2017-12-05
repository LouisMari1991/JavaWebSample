package com.sync.changsha.Utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GsonHelper {
  private static Gson sGson = new Gson();
  private static JsonParser sJsonParser = new JsonParser();

  private GsonHelper() {
  }

  /**
   * 将json数据转化为实体数据
   *
   * @param jsonData json字符串
   * @param entityClass 类型
   * @return 实体
   */
  public static <T> T convertEntity(String jsonData, Class<T> entityClass) {
    T entity = null;
    try {
      entity = sGson.fromJson(jsonData.toString(), entityClass);
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
    }
    return entity;
  }

  /**
   * 将json数据转化为实体列表数据
   *
   * @param jsonData json字符串
   * @param entityClass 类型
   * @return 实体列表
   */
  public static <T> List<T> convertEntities(String jsonData, Class<T> entityClass) {
    List<T> entities = new ArrayList<>();
    try {
      JsonArray jsonArray = sJsonParser.parse(jsonData).getAsJsonArray();
      for (JsonElement element : jsonArray) {
        entities.add(sGson.fromJson(element, entityClass));
      }
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
    }
    return entities;
  }

  /**
   * 将 Object 对象转为 String
   *
   * @param jsonObject json对象
   * @return json字符串
   */
  public static String object2JsonStr(Object jsonObject) {
    return sGson.toJson(jsonObject);
  }

  /**
   * 函数名称: parseData
   * 函数描述: 将json字符串转换为map
   */
  public static Map<String, String> string2Map(String data) {
    Map<String, String> map = sGson.fromJson(data, new TypeToken<Map<String, String>>() {
    }.getType());
    return map;
  }
}
