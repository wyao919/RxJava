import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class DoFinally {

    public static void main(String[] args) {
//        exDoFinally();
        exDoOnDispose();
    }

    public static void exDoFinally() {
        Observable.just(1, 2, 3, 4, 5)
                .doFinally(() -> System.out.println("doFinally: Completed"))
                .doOnComplete(() -> System.out.println("DONE DONE"))
                .subscribe(System.out::println);

    }

    public static void exDoOnDispose() {
        Disposable disposing_after_dispose = Observable.just(1, 2, 3, 4, 5)
                .doOnDispose(() -> System.out.println("disposing after dispose"))
                .doOnSubscribe(Disposable::dispose)
                .subscribe(System.out::println);
    }
}
