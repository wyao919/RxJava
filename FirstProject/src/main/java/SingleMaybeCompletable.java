import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class SingleMaybeCompletable {

    public static void main(String[] args) {
//        createSingle();
//        createMaybe();
        createCompletable();

    }

    public static void createSingle(){

        Single.just("HelloWorld").subscribe(s -> System.out.println(s));

    }
    public static void createMaybe(){

        Maybe.empty().subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {

            }

            @Override
            public void onSuccess(@NonNull Object o) {

            }

            @Override
            public void onError(@NonNull Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("Complete");
            }
        });


    }
    public static void createCompletable(){
        Completable.fromSingle(Single.just("HelloWorld")).subscribe(() -> System.out.println("Completed"));
    }
}
