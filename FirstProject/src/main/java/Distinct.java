import io.reactivex.Observable;

public class Distinct {

    public static void main(String[] args) {
//        distinctOperator();
//        distinctWithKeySelector();
//        distinctUntilChanged();
        distinctUntilChangedWithKeySelector();
    }

    //will not print any duplicates
    private static void distinctOperator(){
        Observable.just(1,1,2,2,3,3,4,5,1,2)
                .distinct()
                .subscribe(System.out::println);
    }

    private static void distinctWithKeySelector(){
        Observable.just("foo", "fool", "foss", "foil")
                .distinct(String::length)
                .subscribe(System.out::println);
    }

    //will not print duplicates that are after each other
    private static void distinctUntilChanged(){
        Observable.just(1,1,2,2,3,3,4,5,1,2)
                .distinctUntilChanged()
                .subscribe(System.out::println);
    }
    private static void distinctUntilChangedWithKeySelector(){
        Observable.just("foo", "fool", "super", "foss", "foil")
                .distinctUntilChanged(String::length)
                .subscribe(System.out::println);
    }



}
