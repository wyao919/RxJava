import io.reactivex.Observable;

public class DefaultSwitchIfEmpty {

    public static void main(String[] args) {
//        useDefaultIfEmpty();
        useSwitchIfEmpty();

    }

    private static void useDefaultIfEmpty(){
        Observable.just(1,2,3,4,5)
                .filter(integer -> integer > 10)
                .defaultIfEmpty(100)
                .subscribe(System.out::println);
    }

    private static void useSwitchIfEmpty(){

        Observable.just(1,2,3,4,11)
                .filter(integer -> integer > 10)
                .switchIfEmpty(Observable.just(6,7,8,9,10))
                .subscribe(System.out::println);

    }

}
