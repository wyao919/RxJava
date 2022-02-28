import io.reactivex.Observable;

public class ObservableErrors {

    public static void main(String[] args) {
//        throwException();
        throwExceptionUsingCallable();
    }

    public static void throwException(){
        Observable<Object> observable = Observable.error(new Exception("An Exception"));
        observable.subscribe(System.out::println, o -> System.out.println("Error 1: "+ o.hashCode()));
        observable.subscribe(System.out::println, o -> System.out.println("Error 2: "+ o.hashCode()));

    }

    public static void throwExceptionUsingCallable(){
        Observable<Object> observable = Observable.error(()-> {
            System.out.println("New Exception Created");
            return new Exception("An Exception");
        });
        observable.subscribe(System.out::println, o -> System.out.println("Error 1: "+ o.hashCode()));
        observable.subscribe(System.out::println, o -> System.out.println("Error 2: "+ o.hashCode()));

    }



}
