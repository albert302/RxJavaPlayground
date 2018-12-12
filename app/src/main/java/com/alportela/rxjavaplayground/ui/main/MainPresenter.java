/*
 * Created by Alberto on 17/10/2018
 */

/*
 * Created by Alberto 2018.
 */

package com.alportela.rxjavaplayground.ui.main;

public class MainPresenter implements MainContract.Presenter{

    public MainContract.View view;
    public MainData mainData;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        MainData mainData = buildMainData();

        view.loadCompleted(mainData);
    }

    public MainData buildMainData() {
        mainData = new MainData();
        mainData.setName("Alberto");
        mainData.setAge(34);
        mainData.setEmail("someemail@gmail.com");

        return mainData;
    }

    @Override
    public void onDetach() {
        view = null;
    }
}
