package com.playbasis.sdk.subscriber;

import com.playbasis.pbcore.domain.subscriber.PBDefaultSubscriber;
import com.playbasis.sdk.callback.BaseApiCallback;
import com.playbasis.sdk.callback.BasicApiCallback;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;

/**
 * Created by Tar on 8/22/16 AD.
 */
public class BaseApiSubscriber<T> extends PBDefaultSubscriber<T> {

  BaseApiCallback c;

  public BaseApiSubscriber(BaseApiCallback callback) {
    this.c = callback;
  }

  @Override
  public void onCompleted() {
    super.onCompleted();

    if (c != null) {
      if (c instanceof BasicApiCallback) {
        ((BasicApiCallback) c).onSuccess();
      } else if (c instanceof BasicApiCallbackWithResult) {
        ((BasicApiCallbackWithResult) c).onSuccess(resultObj);
      }
    }
  }

  @Override
  public void onUseCaseError(Throwable e, PBErrorType errorType) {
    if (c != null) {
      c.onFailed(e, errorType);
    }
  }
}
