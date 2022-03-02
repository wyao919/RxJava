import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class ObservableInterval {

    public static void main(String[] args) {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable subscribe = observable.subscribe(o -> System.out.println("Observer 1: " + o));
        pause(3000);
        System.out.println(subscribe.isDisposed());

        subscribe.dispose();
        System.out.println(subscribe.isDisposed());



    }

    public static void pause(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
