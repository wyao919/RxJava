import io.reactivex.Observable;

import java.io.IOException;

public class ExceptionOnError {

    public static void main(String[] args) {
//        exDoOnError();
//        exOnErrorResumeNext();
        exOnErrorReturn();
    }

    private static void exDoOnError(){

        Observable.error(() -> new Exception("Example error"))
                .onErrorResumeNext(Observable.just(1,2,3,4,5))
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println("subscribe error"),
                        () -> System.out.println("Completed")).dispose();

    }

    //does this instead of an error
    private static void exOnErrorResumeNext(){

        Observable.error(() -> new Exception("Example error"))
                .doOnError(throwable -> System.out.println("ERROR: " + throwable.getMessage()))
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println("subscribe error"),
                        () -> System.out.println("Completed")).dispose();


    }


    private static void exOnErrorReturn(){

        Observable.error(() -> new IOException("Example error"))
                .onErrorReturn(throwable -> {
                    if(throwable instanceof IOException){
                        return 0;
                    }
                    return 1;
                })
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println("subscribe error"),
                        () -> System.out.println("Completed")).dispose();

    }

    private static void exOnErrorReturnItem(){

        Observable.error(() -> new IOException("Example error"))
                .onErrorReturnItem("Hello Item")
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println("subscribe error"),
                        () -> System.out.println("Completed")).dispose();

    }

}
