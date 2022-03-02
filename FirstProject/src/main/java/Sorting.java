import io.reactivex.Observable;

import java.util.Comparator;

public class Sorting {

    public static void main(String[] args) {
//        userSorted();
        useSortedWithOwnComparator();
        useSortedNonComparator();
    }

    private static void userSorted(){
        Observable.just(2,1,4,3,5)
                .sorted()
                .subscribe(System.out::println);
    }

    private static void useSortedWithOwnComparator(){

        Observable.just(2,1,4,3,5)
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);

    }

    private static void useSortedNonComparator(){

        Observable.just("foo", "john","bar")
                .sorted()
                .sorted((o1, o2) -> Integer.compare(o1.length(),o2.length()))
                .subscribe(System.out::println);

    }

}
