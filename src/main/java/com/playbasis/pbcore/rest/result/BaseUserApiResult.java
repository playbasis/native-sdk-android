package com.playbasis.pbcore.rest.result;

/**
 * Created by Tar on 4/28/16 AD.
 */
public abstract class BaseUserApiResult<T> extends PBApiResult<T> {

  public abstract String getUserId();

}
