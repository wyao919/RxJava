import io.reactivex.Observable;

public class DoOnSubscribe {

    public static void main(String[] args) {
        exDoOnSubscribe();
        exDoOnNext();
        exDoOnComplete();
    }

    public static void exDoOnSubscribe() {
        Observable.just(1,2,3,4,5)
                .doOnSubscribe(disposable -> System.out.println("doOnSubscribe: Subscribed"))
                .subscribe(System.out::println);

    }

    public static void exDoOnNext() {
        Observable.just(1,2,3,4,5)
                .doOnNext(disposable -> System.out.println("next"))
                .subscribe(System.out::println);

    }

    public static void exDoOnComplete() {
        Observable.just(1,2,3,4,5)
                .doOnComplete(() -> System.out.println("completed"))
                .subscribe(System.out::println);
    }


}
