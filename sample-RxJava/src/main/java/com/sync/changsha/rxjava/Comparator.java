package com.sync.changsha.rxjava;

import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.functions.Func2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * <p>
 * 排序测试
 * </p>
 * Created by Administrator on 2017/7/7 0007.
 */
public class Comparator {

  @Test
  public void test() {

    List<Integer> list = new ArrayList<>();

    Random random = new Random();

    for (int i = 0; i < 20; i++) {
      list.add(random.nextInt(100));
    }
    System.out.println(list);
    Observable.from(list)
        .filter(integer -> integer.intValue() > 5).toSortedList((integer, integer2) -> {
      if (integer > integer2) {
        return -1;
      } else if (Objects.equals(integer, integer2)) {
        return 0;
      }
      return 1;
    }).subscribe(new Observer<List<Integer>>() {
      @Override
      public void onCompleted() {

      }

      @Override
      public void onError(Throwable throwable) {

      }

      @Override
      public void onNext(List<Integer> integers) {
        System.out.println(integers);
      }
    });
  }
}
