/*
 * Created by Alberto on 18/10/2018
 */

package com.alportela.rxjavaplayground.base;

public interface BaseMvpPresenter<V extends BaseMvpView> {

    void onAttach(V view);

    void onDetach();
}
