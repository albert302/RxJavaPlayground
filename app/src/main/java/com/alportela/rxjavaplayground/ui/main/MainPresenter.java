/*
 * Created by Alberto 2018.
 */

package com.alportela.rxjavaplayground.ui.main;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        MainData mainData = new MainData();
        mainData.setName("Alberto");
        mainData.setAge(34);
        mainData.setEmail("someemail@gmail.com");

        view.loadCompleted(mainData);
    }
}
