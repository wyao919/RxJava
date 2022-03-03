import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Concat {

    public static void main(String[] args) {
//        exConcat();
//        exConcatWith();
        exConcatMap();
    }

    public static void exConcat(){

        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> observable2 = Observable.just(6, 7, 8, 9, 10);


        observable1.concatWith(observable2).subscribe(System.out::println);

    }
    public static void exConcatWith(){

        Observable<String> observable1 = Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .map(aLong -> "Observable1: " + aLong);
        Observable<String> observable2 =  Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(aLong -> "Observable2: " + aLong);


        observable1.concatWith(observable2)
                .subscribe(System.out::println);

        pause(10000);

    }
    public static void exConcatMap(){

        Observable.just("foo" , "bar", "jam")
                .concatMap(item -> Observable.fromArray(item.split("")))
                .subscribe(System.out::println);



    }

    public static void pause(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ignore) {
        }
    }
}
