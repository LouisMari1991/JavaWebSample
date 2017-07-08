package com.sync.changsha.rxjava;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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

  /**
   * switchMap与flatMap和concatMap的区别在于:不好总结:
   *
   * RxJava also implements the switchMap operator. It behaves much like flatMap, except that
   * whenever a new item is emitted by the source Observable, it will unsubscribe to and stop mirroring the Observable that was generated
   * from the previously-emitted item, and begin only mirroring the current one.
   *
   * switch()和flatMap()很像，除了一点:当源Observable发射一个新的数据项时，如果旧数据项订阅还未完成，就取消旧订阅数据和停止监视那个数据项产生的Observable,开始监视新的数据项.
   */
  @Test
  public void switchMap() {

    // 这是在同一线程产生数据，所以当第二个数据项来临时，第一个已经完成了，同理，c,d,e都将完成
    Observable.just("A", "B", "C", "D", "E").switchMap(new Func1<String, Observable<String>>() {
      @Override
      public Observable<String> call(String s) {
        Observable<String> ob = Observable.just(s);
        return ob;
      }
    }).subscribe(new Observer<String>() {
      @Override
      public void onCompleted() {
        System.out.println(" onCompleted ");
      }

      @Override
      public void onError(Throwable throwable) {
        System.out.println(" onError , throwable : " + throwable.toString());
      }

      @Override
      public void onNext(String s) {
        System.out.println(" onNext , result : " + s);
      }
    });

    // 下面来看并发产生数据项: 当源Observable变换出的Observable同时进行时,
    // A --> 取消空的，没有可以取消的
    // B--> A被取消
    // C-->  B被取消
    // D-->  C被取消
    // E-->  D被取消
    Observable.just("A", "B", "C", "D", "E")
        .switchMap(new Func1<String, Observable<String>>() {
          @Override public Observable<String> call(String s) {
            return Observable.just(s).subscribeOn(Schedulers.newThread());
          }
        }).subscribe(new Observer<String>() {
      @Override public void onCompleted() {
        System.out.println(" onCompleted ");
      }

      @Override public void onError(Throwable throwable) {
        System.out.println(" onError , throwable : " + throwable.toString());
      }

      @Override public void onNext(String s) {
        System.out.println(" onNext , result : " + s);
      }
    });
  }
}
