import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class CreatingObservables {

    public static void main(String[] args) {

//        createObservableWithJust();
//        createObservableFromIterable();
        createObservableUsingCreate();

    }

    public static void createObservableWithJust(){
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.subscribe(System.out::println);

    }
    public static void createObservableFromIterable() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Observable<Integer> observable = Observable.fromIterable(list);
        observable.subscribe(System.out::println);

    }

    public static void createObservableUsingCreate() {
        Observable<Integer> observable = Observable.create(observableEmitter -> {
            observableEmitter.onNext(1);
            observableEmitter.onNext(2);
            observableEmitter.onNext(3);
            observableEmitter.onNext(4);
            observableEmitter.onNext(5);
            observableEmitter.onNext(null);

            //this means emission is complete and will notify subscriber
            observableEmitter.onComplete();
        });

        //first line is emitting, second line is onError, third line is onComplete
        observable.subscribe(System.out::println,
                error -> System.out.println("There was an error "+error.getLocalizedMessage()),
                () -> System.out.println("Completed"));

    }

}