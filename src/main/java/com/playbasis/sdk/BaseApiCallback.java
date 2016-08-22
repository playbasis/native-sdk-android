package com.playbasis.sdk;

import com.playbasis.pbcore.domain.subscriber.PBDefaultSubscriber;

/**
 * Created by Tar on 8/22/16 AD.
 */
public interface BaseApiCallback<T> {
  void onSuccess(T result);
  void onFailed(Throwable e, PBDefaultSubscriber.PBErrorType errorType);
}
