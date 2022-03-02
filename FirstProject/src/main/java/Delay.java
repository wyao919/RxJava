import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Delay {


    public static void main(String[] args) {
//        delay();
        delayError();
//        pause();

    }


    private static void delay(){
        Observable.just(1,2,3,4,5)
                .delay(3000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);
        pause(5000);
    }
    private static void delayError(){
        Observable.error(new Exception("ErrorNow"))
                .delay(3000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println,
                        throwable -> System.out.println(throwable.getLocalizedMessage()), ()->
                        System.out.println("Completed"));

        pause(5000);
    }
    private static void pause(int duration){

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {

        }

    }




}
