import io.reactivex.Observable;

public class EmptyAndNever {

    public static void main(String[] args) {

        createObservableUsingEmpty();
//        createObservableUsingNever();
    }


    //for emitting empty. It will just go to on Complete
    public static void createObservableUsingEmpty(){

        Observable<Object> observable = Observable.empty();
        observable.subscribe(System.out::println,
                error -> System.out.println(error.getMessage()), () -> System.out.println("Completed"));
    }

    //will never emit anything
    public static void createObservableUsingNever(){
        Observable<Object> observable = Observable.never();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        observable.subscribe(System.out::println,
                error -> System.out.println(error.getMessage()),() -> System.out.println("Completed"));



    }
}
