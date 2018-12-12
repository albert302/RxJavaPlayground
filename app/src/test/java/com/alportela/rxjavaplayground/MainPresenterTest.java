/*
 * Created by Alberto on 18/10/2018
 */

package com.alportela.rxjavaplayground;

import com.alportela.rxjavaplayground.ui.main.MainContract;
import com.alportela.rxjavaplayground.ui.main.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MainPresenterTest {

    @Mock
    private MainContract.View view;

    private MainContract.Presenter presenter;

    @Before
    public void setUp() {
        // A convenient way to inject mocks by using the @Mock annotation in Mockito.
        //  For mock injections , initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        presenter = new MainPresenter(view);
    }

    @Test
    public void testDetachView() {
        presenter.onDetach();


    }

}
