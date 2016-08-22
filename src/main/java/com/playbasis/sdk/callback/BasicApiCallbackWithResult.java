package com.playbasis.sdk.callback;

/**
 * Created by Tar on 8/22/16 AD.
 */
public interface BasicApiCallbackWithResult<T> extends BaseApiCallback {
  void onSuccess(T t);
}
