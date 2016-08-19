package com.playbasis.pbcore.domain.interactor.content;

import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.result.content.ContentOpinionApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class DislikeContentInteractor extends ContentOpinionInteractor {

  public static final String TAG = "DislikeContentInteractor";

  @Inject
  public DislikeContentInteractor(PBThreadExecutor threadExecutor,
                                  PBPostExecutionThread postExecutionThread,
                                  RestClient restClient,
                                  RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getContentService().dislikeContent(
        getApiToken(),
        contentOpinionForm.getNodeId(),
        contentOpinionForm.getPlayerId(),
        contentOpinionForm.getFields()
    ).map(new PBApiErrorCheckFunc<ContentOpinionApiResult>());
  }
}
