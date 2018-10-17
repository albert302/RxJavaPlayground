package com.alportela.rxjavaplayground.rxoperators;

import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class OperatorBuffer {

    private static final String TAG = "Rx:OperatorBuffer";

    //RxJava
    private CompositeDisposable disposables = new CompositeDisposable();
    private Observable<Integer> rangeObservable;
    private DisposableObserver<List<Integer>> observer;

    String[] greetings = {"Hello", "Hola", "Bonjour", "Mikato", "Jamon", "Helio Flat Map"};

    public void execute() {
        rangeObservable = Observable.range(1, 20);

        disposables.add(rangeObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .buffer(4)
                .subscribeWith(getObserver()));
    }

    private DisposableObserver getObserver() {

        observer = new DisposableObserver<List<Integer>>() {
            @Override
            public void onNext(List<Integer> numbers) {
                Log.e(TAG, "Next: " + numbers.toString());
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
