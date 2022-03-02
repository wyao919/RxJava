import io.reactivex.Observable;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Retry {


    public static void main(String[] args) {

//        retryWithPredicate();
//        exRetry();
        exRetryUntil();

    }

    private static void retryWithPredicate(){
        Observable.error(() -> new IOException("Example error"))
                .retry(throwable -> {
                    if(throwable instanceof IOException){
                        System.out.println("retrying");
                        return true;
                    }
                    return false;
                })
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println("subscribe error"),
                        () -> System.out.println("Completed")).dispose();
    }

    private static void exRetry(){

        Observable.error(() -> new IOException("Example error"))
                .retry()
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println("subscribe error"),
                        () -> System.out.println("Completed")).dispose();
    }

    private static void exRetryUntil(){
        AtomicInteger atomicInteger= new AtomicInteger();

        Observable.error(() -> new IOException("Example error"))
                .doOnError(error -> {
                    System.out.println("retrying atomic integer");
                     atomicInteger.getAndIncrement();
                })
                .retryUntil(() -> atomicInteger.get() >= 3)
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println("subscribe error2"),
                        () -> System.out.println("Completed")).dispose();
    }
}
