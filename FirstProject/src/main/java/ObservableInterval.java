import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableInterval {

    public static void main(String[] args) {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        observable.subscribe(o -> System.out.println("Observer 1: " + o));

        pause(2000);

        observable.subscribe(o -> System.out.println("Observer 2: " + o));

        pause(3000);

    }

    public static void pause(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
