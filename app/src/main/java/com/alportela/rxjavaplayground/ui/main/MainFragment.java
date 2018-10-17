package com.alportela.rxjavaplayground.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alportela.rxjavaplayground.R;
import com.alportela.rxjavaplayground.retrofit.GetCountryDataService;
import com.alportela.rxjavaplayground.retrofit.RetrofitInstance;
import com.alportela.rxjavaplayground.retrofit.model.Info;
import com.alportela.rxjavaplayground.rxoperators.OperatorBuffer;
import com.alportela.rxjavaplayground.rxoperators.OperatorFilter;
import com.alportela.rxjavaplayground.rxoperators.OperatorFromArray;
import com.alportela.rxjavaplayground.rxoperators.OperatorMap;
import com.alportela.rxjavaplayground.rxsubjects.SubjectAsync;
import com.alportela.rxjavaplayground.rxsubjects.SubjectBehavior;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class MainFragment extends Fragment implements MainContract.View {

    private static final String TAG = MainFragment.class.getSimpleName();

    private MainViewModel mViewModel;

    private MainContract.Presenter presenter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        presenter = new MainPresenter(this);

        init();

        View view = inflater.inflate(R.layout.main_fragment, container, false);

        Button btnFirst = view.findViewById(R.id.buttonFirst);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "CLICK");

                init();

                retrofit();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.loadData();
    }

    @Override
    public void loadCompleted(MainData mainData) {
        Log.e(TAG, mainData.toString());

    }

    private void init() {
        OperatorFromArray fromArray = new OperatorFromArray();
        fromArray.execute();

        OperatorFilter filter = new OperatorFilter();
        filter.execute();

        OperatorMap map = new OperatorMap();
        map.execute();

        OperatorBuffer buffer = new OperatorBuffer();
        buffer.execute();

        SubjectAsync async = new SubjectAsync();
        async.execute();

        SubjectBehavior behavior = new SubjectBehavior();
        behavior.execute();
    }

    private void retrofit() {


    }

    private Object getCountries() {
        GetCountryDataService getCountryDataService = RetrofitInstance.getService();


        Call<Info> callCountry = getCountryDataService.getCountry("AO");

        Map<String, String> queryData = new HashMap<>();
        queryData.put("sort", "some value");
        queryData.put("type", "type value");

        Call call = getCountryDataService.getUsers(queryData);

        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}
