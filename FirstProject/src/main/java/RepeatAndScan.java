import io.reactivex.Observable;

public class RepeatAndScan {

    public static void main(String[] args) {
//        useRepeat();
//        useScan();
        useScanWithInitialValue();
    }

    private static void useRepeat(){
        Observable.just(1,2,3,4,5)
                .repeat(2)
                .subscribe(System.out::println);
    }

    private static void useScan(){

        Observable.just(1,2,3,4,5)
                .scan((accumulator, integer2) -> accumulator + integer2)
                .subscribe(System.out::println);

    }

    private static void useScanWithInitialValue(){

        Observable.just(1,2,3,4,5)
                .scan(10, (accumulator, integer2) -> accumulator + integer2)
                .subscribe(System.out::println);

    }

}
