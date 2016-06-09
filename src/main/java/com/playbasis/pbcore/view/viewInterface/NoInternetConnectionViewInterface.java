package com.playbasis.pbcore.view.viewInterface;

import rx.subjects.PublishSubject;

/**
 * Created by gregoire on 1/5/2559.
 */
public interface NoInternetConnectionViewInterface {

  PublishSubject<Integer> noInternetConnection(Throwable retrofitError);

}
