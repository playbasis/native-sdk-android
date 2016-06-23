package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.result.ContentOpinionApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class LikeContentInteractor extends ContentOpinionInteractor {

  @Inject
  public LikeContentInteractor(ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread,
                               RestClient restClient,
                               RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getContentService().likeContent(
        getApiToken(),
        form.getNodeId(),
        form.getPlayerId(),
        form.getKeys(),
        form.getValues()
    ).map(new PBApiErrorCheckFunc<ContentOpinionApiResult>());
  }
}
