package com.alportela.rxjavaplayground.rxoperators;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class OperatorFlatMap {

    private static final String TAG = "Rx:OperatorFlatMap";

    //RxJava
    private CompositeDisposable disposables = new CompositeDisposable();
    private Observable<String> stringObservable;
    private DisposableObserver<String> observer;

    String[] greetings = {"Hello", "Hola", "Bonjour", "Mikato", "Jamon", "Helio Flat Map"};

    public void execute() {
        stringObservable = Observable.fromArray(greetings);

        disposables.add(stringObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.toLowerCase().startsWith("h");
                    }
                })
                .flatMap(new Function<String, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(String s) throws Exception {
                        s.toUpperCase();
                        return Observable.just(s);
                    }
                })
                .subscribeWith(getObserver()));
    }

    private DisposableObserver getObserver() {

        observer = new DisposableObserver<String>() {
            @Override
            public void onNext(String string) {
                Log.e(TAG, "Next: " + string);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");
            }
        };

        return observer;
    }
}
