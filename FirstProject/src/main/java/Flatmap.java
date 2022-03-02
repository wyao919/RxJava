import io.reactivex.Observable;

public class Flatmap {

    public static void main(String[] args) {

//        exFlatMap();
        exFlatMapBiFunction();
    }

    public static void exFlatMap(){
        Observable<String> observable = Observable.just("foo", "bar", "jar");
                observable
                        .flatMap(s -> {

                            if(s.equals("bar")){
                                return Observable.empty();
                            }
                            return Observable.fromArray(s.split(""));
                        })
                        .subscribe(System.out::println);

    }
    public static void exFlatMapBiFunction(){

        Observable<String> observable = Observable.just("foo", "bar", "jar");
        observable
                .flatMap(s -> Observable.fromArray(s.split("")),
                        (actual, s2) -> actual + " " + s2)
                .subscribe(System.out::println);


    }

}
