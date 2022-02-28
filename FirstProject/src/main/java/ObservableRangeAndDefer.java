import io.reactivex.Observable;

public class ObservableRangeAndDefer {

    private static int start = 5, count =2;

    public static void main(String[] args) {

        Observable<Integer> observable = Observable.defer(() -> {

            System.out.println("New observable is created with start = "+ start + " and count " + count);
            return Observable.range(start, count);
        });
        observable.subscribe(integer -> System.out.println("Observer 1: " + integer));

        count =3;

        observable.subscribe(integer -> System.out.println("Observer 2: " + integer));
    }
}
