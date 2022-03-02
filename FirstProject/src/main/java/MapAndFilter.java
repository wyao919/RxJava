import io.reactivex.Observable;

public class MapAndFilter {

    public static void main(String[] args) {

        mapOperator();
        mapReturnsDifferentData();
        filterOperator();
        mapAndFilter();

    }

    public static void mapOperator(){

        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable
                .map(integer -> integer * 2)
                .subscribe(System.out::println);
    }

    public static void mapReturnsDifferentData(){

        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable
                .map(integer -> "Hello World")
                .subscribe(System.out::println);
    }

    public static void filterOperator(){

        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable
                .filter(integer -> integer % 2 ==0)
                .subscribe(System.out::println);
    }

    public static void mapAndFilter(){

        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable
                .map(integer -> integer * 2)
                .filter(integer -> integer % 2 == 0)
                .subscribe(System.out::println);
    }



}
