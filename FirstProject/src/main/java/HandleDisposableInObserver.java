import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class HandleDisposableInObserver {

    public static void main(String[] args) {

        compositeDisposable();

    }

    public static void handleDisposableOutSideObserver() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        ResourceObserver<Integer> observer = new ResourceObserver<Integer>() {

            @Override
            public void onNext(@NonNull Integer integer) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        ResourceObserver<Integer> integerResourceObserver = observable.subscribeWith(observer);
    }

    public static void compositeDisposable(){


        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = observable.subscribe(item -> System.out.println("Observer 1: " + item));
        Disposable disposable2 = observable.subscribe(item -> System.out.println("Observer 2: " + item));

        compositeDisposable.addAll(disposable, disposable2);

        pause();
        compositeDisposable.delete(disposable);
        compositeDisposable.dispose();
        pause();
    }

    public static void pause(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {

        }
    }

}