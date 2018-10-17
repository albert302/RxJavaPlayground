package com.alportela.rxjavaplayground.rxoperators;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class OperatorFilter extends BaseOperator{

    private static final String TAG = "Rx:OperatorFilter";

    //RxJava
    private CompositeDisposable disposables = new CompositeDisposable();
    private Observable<String> stringObservable;
    private DisposableObserver<String> observer;

    String[] greetings = {"Hello", "Hola", "Bonjour", "Mikato", "Jamon"};

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

    @Override
    public void unsubscribe() {
        disposables.clear();
    }
}
