import io.reactivex.Observable;

public class ObservableRange {

    public static void main(String[] args) {
//        Observable<Integer> observable = Observable.range(0,10);
//        observable.subscribe(System.out::println);

        int start = 5;
        int count = 2;
        Observable<Integer> observable = Observable.range(start,count);
        observable.subscribe(System.out::println);
    }
}
