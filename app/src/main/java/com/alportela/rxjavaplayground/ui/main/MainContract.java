package com.alportela.rxjavaplayground.ui.main;

public interface MainContract {

    interface View {

        void loadCompleted(MainData mainData);
    }

    interface Presenter {

        void onDetach();

        void loadData();
    }
}
