package com.ps.pslibrary.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class AndroidScheduler implements ApplicationScheduler {

    private final Map<String, List<Disposable>> subscriptions = new HashMap<>();
    private final Scheduler observingScheduler;
    private final Scheduler executingScheduler;

    public AndroidScheduler(Scheduler observingScheduler, Scheduler executingScheduler) {
        this.observingScheduler = observingScheduler;
        this.executingScheduler = executingScheduler;
    }

    @Override
    public <C> void schedule(Observable<C> observable, Consumer<C> onNextAction, Consumer<Throwable> onErrorAction, Object subscriber) {
        List<Disposable> objectSubscriptions = getSubscriptions(subscriber);
        objectSubscriptions.add(observable
                .observeOn(observingScheduler)
                .subscribeOn(executingScheduler)
                .subscribe(onNextAction, onErrorAction));
    }

    @Override
    public <C> void schedule(Single<C> single, Consumer<C> onNextAction, Consumer<Throwable> onErrorAction, Object subscriber) {
        List<Disposable> objectSubscriptions = getSubscriptions(subscriber);
        objectSubscriptions.add(single
                .observeOn(observingScheduler)
                .subscribeOn(executingScheduler)
                .subscribe(onNextAction, onErrorAction));
    }

    private String getSubscriberTag(Object subscriber) {
        return subscriber.toString();
    }

    private List<Disposable> getSubscriptions(Object subscriber) {
        String tag = getSubscriberTag(subscriber);
        List<Disposable> objectSubscriptions = subscriptions.get(tag);
        if (objectSubscriptions == null) {
            objectSubscriptions = new ArrayList<>();
            subscriptions.put(tag, objectSubscriptions);
        }
        return objectSubscriptions;
    }

    @Override
    public int disposeFor(Object subscriber) {
        String tag = getSubscriberTag(subscriber);

        if (!subscriptions.containsKey(tag)) {
            return 0;
        }

        List<Disposable> taggedSubscriptions = this.subscriptions.get(tag);
        int numberOfSubscriptions = taggedSubscriptions.size();
        for (Disposable subscription : taggedSubscriptions) {
            subscription.dispose();
        }
        subscriptions.remove(tag);
        return numberOfSubscriptions;
    }

    @Override
    public Scheduler subscribeOnScheduler() {
        return executingScheduler;
    }

    @Override
    public Scheduler observeOnScheduler() {
        return observingScheduler;
    }
}