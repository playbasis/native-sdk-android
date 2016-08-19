package com.playbasis.pbcore.domain.subscriber;

import com.playbasis.pbcore.rest.error.PBApiError;
import com.playbasis.pbcore.rest.error.UserAbortError;

import rx.Subscriber;

/**
 * Created by Tar on 5/4/16 AD.
 */
public abstract class PBDefaultSubscriber<T> extends Subscriber<T> {
  public T resultObj;
  public Throwable error;

  @Override
  public void onCompleted() {

  }

  @Override
  public final void onError(Throwable e) {
    error = e;

    PBErrorType errorType;
    if (e == null) {
      errorType = PBErrorType.UNDEFINED;
    } else if (e instanceof UserAbortError) {
      errorType = PBErrorType.USER_ABORT_ERROR;
    } else if (e instanceof PBApiError) {
      errorType = PBErrorType.API_ERROR;
    } else {
      errorType = PBErrorType.USE_CASE_ERROR;
    }

    onUseCaseError(error, errorType);
  }

  @Override
  public void onNext(T t) {
    resultObj = t;
  }

  public abstract void onUseCaseError(Throwable e, PBErrorType errorType);

  protected final boolean hasResult() {
    return resultObj != null;
  }

  public enum PBErrorType {
    USER_ABORT_ERROR,
    API_ERROR,
    USE_CASE_ERROR,
    UNDEFINED
  }
}
