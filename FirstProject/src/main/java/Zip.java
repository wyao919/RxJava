import io.reactivex.Observable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Zip {

    public static void main(String[] args) {
//        exZip();
//        exZipWith();
        exZipIterable();

    }

    private static void exZip(){
        Observable<Integer> oneToFive = Observable.just(2, 1, 4, 3, 5);
        Observable<Integer> sixToTen = Observable.range(6, 5);
        Observable<Integer> elevenToFifteen = Observable.fromIterable(Arrays.asList(11, 12, 13, 14, 15));

        Observable.zip(oneToFive,sixToTen,elevenToFifteen, (a, b, c) -> a+b+c).subscribe(System.out::println);


    }

    private static void exZipWith(){
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.range(6, 5);

        oneToFive.zipWith(sixToTen, Integer::sum).subscribe(System.out::println);


    }

    private static void exZipIterable(){
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.range(6, 5);
        Observable<Integer> elevenToFifteen = Observable.range(11, 5);
        List<Observable<Integer>> observableList = Arrays.asList(oneToFive, sixToTen, elevenToFifteen);
        Observable.zipIterable(observableList, Arrays::toString, true ,1)
                .subscribe(System.out::println);




    }
}
