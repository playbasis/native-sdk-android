package com.playbasis.pbcore.rest.error;

import com.playbasis.pbcore.rest.result.PBApiResult;

/**
 * Created by Tar on 6/16/16 AD.
 */
public class PBApiError extends Error {

  PBApiResult pbApiResult;

  public PBApiError(PBApiResult pbApiResult) {
    this.pbApiResult = pbApiResult;
  }

  @Override
  public String getMessage() {
    return pbApiResult.message;
  }

  @Override
  public String getLocalizedMessage() {
    return getMessage();
  }

  public String getErrorCode() {
    return pbApiResult.errorCode;
  }

  public Long getTimeStamp() {
    return pbApiResult.timeStamp;
  }

  public String getTime() {
    return pbApiResult.time;
  }

  public String getVersion() {
    return pbApiResult.version;
  }

  public PBApiResult getPbApiResult() {
    return pbApiResult;
  }
}
