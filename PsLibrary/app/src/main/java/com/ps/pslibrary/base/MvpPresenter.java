package com.ps.pslibrary.base;

public interface MvpPresenter<V> {

    void attachView(V view);

    void detachView();
}