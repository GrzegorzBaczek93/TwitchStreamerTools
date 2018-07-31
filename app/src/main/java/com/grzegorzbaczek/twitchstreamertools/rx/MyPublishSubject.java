package com.grzegorzbaczek.twitchstreamertools.rx;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public abstract class MyPublishSubject<T> extends Subject<T> {
    private PublishSubject<T> publishSubject = PublishSubject.create();

    public abstract void onSubscribeHandler();

    @Override
    public boolean hasObservers() {
        return publishSubject.hasObservers();
    }

    @Override
    public boolean hasThrowable() {
        return publishSubject.hasThrowable();
    }

    @Override
    public boolean hasComplete() {
        return publishSubject.hasComplete();
    }

    @Override
    public Throwable getThrowable() {
        return publishSubject.getThrowable();
    }

    @Override
    protected void subscribeActual(Observer<? super T> observer) {
        publishSubject.subscribeActual(observer);
        onSubscribeHandler();
    }

    @Override
    public void onSubscribe(Disposable d) {
        publishSubject.onSubscribe(d);
    }

    @Override
    public void onNext(T t) {
        publishSubject.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        publishSubject.onError(e);
    }

    @Override
    public void onComplete() {
        publishSubject.onComplete();
    }
}
