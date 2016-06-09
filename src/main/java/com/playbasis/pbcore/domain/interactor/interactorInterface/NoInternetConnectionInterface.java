package com.playbasis.pbcore.domain.interactor.interactorInterface;

import rx.subjects.PublishSubject;

/**
 * Created by androiddev01 on 4/29/2016 AD.
 */
public interface NoInternetConnectionInterface {
  PublishSubject<Integer> noInternetConnection(Throwable retrofitError);
}
