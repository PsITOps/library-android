package com.ps.pslibrary.application;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public interface ApplicationScheduler {

    <C> void schedule(Observable<C> observable,
                      Consumer<C> onNextAction,
                      Consumer<Throwable> onErrorAction,
                      Object subscriber);

    <C> void schedule(Single<C> single,
                      Consumer<C> onNextAction,
                      Consumer<Throwable> onErrorAction,
                      Object subscriber);

    int disposeFor(Object subscriber);

    Scheduler subscribeOnScheduler();

    Scheduler observeOnScheduler();
}
