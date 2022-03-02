import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MergeObservables {


    public static void main(String[] args) {

//        exMerge();
//        exMergeArray();
//        exMergeIterable();
//        exMergeArrayWith();
        exMergeArrayInfinite();
    }

    public static void exMerge() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);


        Observable.merge(oneToFive, sixToTen).subscribe(System.out::println);

    }

    public static void exMergeArray() {

        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14, 15);
        Observable<Integer> sixteenToTwenty = Observable.just(16, 17, 18, 19, 20);
        Observable<Integer> twentyOneToTwentyFive = Observable.just(21, 22, 23, 24, 25);

        Observable.mergeArray(oneToFive, sixToTen, elevenToFifteen, sixteenToTwenty, twentyOneToTwentyFive)
                .subscribe(System.out::println);
    }

    public static void exMergeIterable() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14, 15);
        Observable<Integer> sixteenToTwenty = Observable.just(16, 17, 18, 19, 20);
        Observable<Integer> twentyOneToTwentyFive = Observable.just(21, 22, 23, 24, 25);

        List<Observable<Integer>> observableList = Arrays.asList(oneToFive, sixToTen, elevenToFifteen, sixteenToTwenty, twentyOneToTwentyFive);
        Observable.merge(observableList).subscribe(System.out::println);

    }

    public static void exMergeArrayWith() {

        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        oneToFive.mergeWith(sixToTen).subscribe(System.out::println);

    }

    public static void exMergeArrayInfinite() {


        Observable<String> observable = Observable.interval(1, TimeUnit.SECONDS)
                .map(item -> "From infinite 1: " + item);

        Observable<String> observable2 = Observable.interval(2, TimeUnit.SECONDS)
                .map(item -> "From infinite 1: " + item);

        observable.mergeWith(observable2).subscribe(System.out::println);
        pause(6000);

    }


    public static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ignored) {

        }
    }
}
