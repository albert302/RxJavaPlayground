package com.alportela.rxjavaplayground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alportela.rxjavaplayground.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}
