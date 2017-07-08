package com.sync.changsha.rxjava;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * <p>
 * 转换测试
 * </p>
 * Created by Administrator on 2017/7/9 0009.
 */
public class Transforming {

  @Test
  public void concatMap() {

    Observable.just(10, 20, 30)
        .concatMap(new Func1<Integer, Observable<Integer>>() {
          @Override public Observable<Integer> call(Integer integer) {
            // 10的延迟执行时间为200毫秒、20和30的延迟执行时间为180毫秒
            int delay = 200;
            if (integer > 10) {
              delay = 180;
            }
            return Observable.from(new Integer[] {integer, integer / 2}).delay(delay, TimeUnit.MILLISECONDS);
          }
        }).subscribe(new Observer<Integer>() {
      @Override public void onCompleted() {
        System.out.println(" onCompleted ");
      }

      @Override public void onError(Throwable throwable) {
        System.out.println(" onError , throwable : " + throwable.toString());
      }

      @Override public void onNext(Integer integer) {
        System.out.println(" onNext , result : " + integer);
      }
    });
  }


}
