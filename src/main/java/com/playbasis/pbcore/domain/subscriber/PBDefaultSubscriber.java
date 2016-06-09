package com.playbasis.pbcore.domain.subscriber;

import com.playbasis.pbcore.rest.error.UserAbortError;
import com.smartsoftasia.ssalibrary.domain.subscriber.DefaultSubscriber;

/**
 * Created by Tar on 5/4/16 AD.
 */
public abstract class PBDefaultSubscriber<T> extends DefaultSubscriber<T> {
  public T resultObj;

  @Override
  public void onCompleted() {

  }

  @Override
  public final void onError(Throwable e) {
    if (e instanceof UserAbortError) {
      onUserAbort((UserAbortError) e);
    } else {
      onUseCaseError(e);
    }
  }

  @Override
  public void onNext(T t) {
    resultObj = t;
  }

  public abstract void onUserAbort(UserAbortError e);

  public abstract void onUseCaseError(Throwable e);

  protected final boolean hasResult() {
    return resultObj != null;
  }
}
