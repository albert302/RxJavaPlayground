/*
 * Created by Alberto on 17/10/2018
 */

package com.alportela.rxjavaplayground;

import com.alportela.rxjavaplayground.ui.main.MainContract;
import com.alportela.rxjavaplayground.ui.main.MainData;
import com.alportela.rxjavaplayground.ui.main.MainFragment;
import com.alportela.rxjavaplayground.ui.main.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class MainDataTest {

    @Mock
    MainPresenter presenter;
    @Mock
    MainData mainData;

    MainFragment mainFragment;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mainFragment = new MainFragment();
        mainFragment.presenter = presenter;
    }

    @Test
    public void testPresenterCreate() {
        MainPresenter mainPresenter = new MainPresenter(mock(MainFragment.class));
        assertNotNull(mainPresenter.view);
    }

    @Test
    public void testPresenterDetach() {
        MainPresenter mainPresenter = new MainPresenter(mock(MainFragment.class));
        mainPresenter.onDetach();
        assertNull(mainPresenter.view);
    }

    @Test
    public void testDetachView() throws Exception {
        mainFragment.onDetach();
        assertNull(presenter.view);
        verify(presenter).onDetach();
    }

    @Test
    public void loadData_isCorrect() {

        //define return value for method loadData()
        when(presenter.buildMainData()).thenReturn(presenter.mainData);
        assertNotNull(presenter.mainData);
        assertEquals("Alberto", presenter.mainData.getName());
        assertEquals(34, presenter.mainData.getAge());
    }

    @Test
    public void mockView() {
        MainContract.View view = mock(MainFragment.class);
        MainPresenter mainPresenter = new MainPresenter(view);
    }
}
