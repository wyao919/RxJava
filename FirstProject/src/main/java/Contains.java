import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class Contains {

    public static void main(String[] args) {
        contains();
        containsWithNonPrimitive();
    }

    private static void contains(){
        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5);

        Disposable subscribe = just
                .contains(3)
                .subscribe(System.out::println);
        subscribe.dispose();
    }

    private static void containsWithNonPrimitive(){

        var user  = new User("Willy");
        Observable.just(user)
                .contains(user)
                .subscribe(System.out::println);
    }


}

class User {

    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
