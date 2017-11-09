package com.sync.changsha.rxjava;

import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by Administrator on 2017/11/9 0009.
 */
public class Repeat {

  int index;

  @Test
  public void test() {
    Observable.just("").repeat()
        .flatMap(new Func1<String, Observable<Integer>>() {
          @Override public Observable<Integer> call(String s) {
            index++;
            System.out.println("call : " + index);
            return Observable.just(index);
          }
        }).subscribe(new Observer<Integer>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable throwable) {

      }

      @Override public void onNext(Integer integer) {
        System.out.println("onNext : " + integer);
      }
    });
  }
}
