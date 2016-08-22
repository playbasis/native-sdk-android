package com.playbasis.sdk;

import com.playbasis.pbcore.domain.subscriber.PBDefaultSubscriber;

/**
 * Created by Tar on 8/22/16 AD.
 */
public class APIDefaultSubscriber<T> extends PBDefaultSubscriber<T> {
  BaseApiCallback<T> callback;

  public APIDefaultSubscriber(BaseApiCallback<T> callback) {
    this.callback = callback;
  }

  @Override
  public void onCompleted() {
    super.onCompleted();

    if (callback != null) {
      callback.onSuccess(resultObj);
    }
  }

  @Override
  public void onUseCaseError(Throwable e, PBErrorType errorType) {
    if (callback != null) {
      callback.onFailed(e, errorType);
    }
  }
}
