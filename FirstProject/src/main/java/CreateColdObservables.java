import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

public class CreateColdObservables {

    public static void main(String[] args) throws InterruptedException {
//        createColdObservables();
        createHotAndConnectableObservable();
    }

    public static void createColdObservables() throws InterruptedException {

        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        System.out.println("First observable");
        observable.subscribe(System.out::println);

        Thread.sleep(3000);

        System.out.println("Second observable");
        observable.subscribe(System.out::println);

    }

    public static void createHotAndConnectableObservable()  {
        ConnectableObservable<Integer> observable = Observable.just(1, 2, 3, 4, 5).publish();

        //Subscribe will only work after you connect
        observable.subscribe(integer -> System.out.println("observer 1: "+integer));

        observable.connect();

        observable.subscribe(integer -> System.out.println("observer 2: "+integer));




    }


    }
