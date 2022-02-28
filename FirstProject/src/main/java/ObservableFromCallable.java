import io.reactivex.Observable;

public class ObservableFromCallable {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.fromCallable(() -> {
            System.out.println("Calling method");
           return getNumber();
        });

        observable.subscribe(integer -> System.out.println(integer),
                error -> System.out.println(error.getLocalizedMessage()),
                () -> System.out.println("completed"));
    }

    private static Integer getNumber() {
        System.out.println("Generating Value");
        return 1/0;
    }

}
