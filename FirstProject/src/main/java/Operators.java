import io.reactivex.Observable;

import java.time.Period;
import java.util.concurrent.TimeUnit;

public class Operators {

    public static void main(String[] args) {

//        takeOperator();
//        takeWithInterval();
//        takeWhileOperator();
//        skipOperator();
        skipWhile();

    }

    public static void takeOperator() {
        //take only the amount of admissions in take
        Observable.just(1,2,3,4,5)
                .take(2)
                .subscribe(System.out::println);

    }

    public static void takeWithInterval() {
        //take only the amount of admissions in take
        Observable.interval(300 , TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(System.out::println, System.out::println ,() -> System.out.println("completed"));
        pause(5000);

    }

    public static void takeWhileOperator() {
        Observable.just(1,2,3,4,5)
                .takeWhile(integer -> integer  <= 3)
                .subscribe(System.out::println);
    }

    public static void skipOperator() {
        Observable.just(1,2,3,4,5)
                .skip(2)
                .subscribe(System.out::println);
    }

    public static void skipWhile() {
        Observable.just(1,2,3,4,5)
                .skipWhile(item -> item < 3)
                .subscribe(System.out::println);
    }


    static void pause(int time){

        try {
            Thread.sleep(time);
        } catch (InterruptedException ignored) {

        }

    }

}
