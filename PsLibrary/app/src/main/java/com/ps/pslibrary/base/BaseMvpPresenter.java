package com.ps.pslibrary.base;

public abstract class BaseMvpPresenter<V> implements MvpPresenter<V> {

    protected V view;

    public BaseMvpPresenter() {
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}