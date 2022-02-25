import io.reactivex.Observable;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        Observable.just(1, 2, 3, 4, 5)
                .subscribe(System.out::println);


    }

}
