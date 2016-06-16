package com.playbasis.pbcore.rest.result.function;

import com.playbasis.pbcore.rest.error.PBApiError;
import com.playbasis.pbcore.rest.result.PBApiResult;

import rx.exceptions.Exceptions;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/27/2016 AD.
 */
public class PBApiErrorCheckFunc<T extends PBApiResult> implements Func1<T,T> {
  public static final String TAG = "PBApiErrorCheckFunc";

  @Override
  public T call(T t) {
    if (!t.success){
      throw Exceptions.propagate(new PBApiError(t));
    }
    return t;
  }
}
