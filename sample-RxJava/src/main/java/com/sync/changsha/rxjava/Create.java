package com.sync.changsha.rxjava;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import rx.Observable;
import rx.Observer;

/**
 * Created by Administrator on 2018/1/18.
 */
public class Create {

  @Test
  public void testJust() {
    List<String> stringList = new ArrayList<>();
    List<String> stringList1 = new ArrayList<>();
    stringList.add("1");
    stringList.add("2");
    stringList.add("3");
    stringList.add("4");
    stringList1.add("5");
    stringList1.add("6");
    stringList1.add("7");
    stringList1.add("8");

    Observable.just(stringList, stringList1)
        .subscribe(new Observer<List<String>>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable throwable) {

          }

          @Override public void onNext(List<String> list) {
            System.out.println(list.size());
            System.out.println(list);
          }
        });
  }

  @Test
  public void testMerge() {
    List<String> stringList = new ArrayList<>();
    List<String> stringList1 = new ArrayList<>();
    stringList.add("1");
    stringList.add("2");
    stringList.add("3");
    stringList.add("4");
    stringList1.add("5");
    stringList1.add("6");
    stringList1.add("7");
    stringList1.add("8");

    Observable<List<String>> just = Observable.just(stringList);
    Observable<List<String>> just1 = Observable.just(stringList1);
    Observable.merge(just, just1).subscribe(list -> {
      System.out.println(list.size());
      System.out.println(list);
    });
  }

  @Test
  public void testZip() {
    List<String> stringList = new ArrayList<>();
    List<String> stringList1 = new ArrayList<>();
    stringList.add("1");
    stringList.add("2");
    stringList.add("3");
    stringList.add("4");
    stringList1.add("5");
    stringList1.add("6");
    stringList1.add("7");
    stringList1.add("8");

    Observable<List<String>> just = Observable.just(stringList);
    Observable<List<String>> just1 = Observable.just(stringList1);

    Observable<List<String>> zip =
        Observable.zip(just, just1, (list, list2) -> {
          list.addAll(list2);
          return list;
        });

    zip.subscribe(list -> System.out.println(list));
  }
}
