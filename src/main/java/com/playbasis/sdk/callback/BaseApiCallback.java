package com.playbasis.sdk.callback;

import com.playbasis.pbcore.domain.subscriber.PBDefaultSubscriber;

/**
 * Created by Tar on 8/22/16 AD.
 */
public interface BaseApiCallback {
  void onFailed(Throwable e, PBDefaultSubscriber.PBErrorType errorType);
}
