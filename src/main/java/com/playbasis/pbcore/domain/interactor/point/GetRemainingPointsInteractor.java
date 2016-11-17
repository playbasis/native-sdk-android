package com.playbasis.pbcore.domain.interactor.point;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Nott on 16/11/2559.
 * playbasis-sdk-android-project
 */

public class GetRemainingPointsInteractor extends PlayBasisApiInteractor {

  @Inject
  public GetRemainingPointsInteractor(PBThreadExecutor threadExecutor,
                                      PBPostExecutionThread postExecutionThread,
                                      RestClient restClient,
                                      RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return null;
  }
}
