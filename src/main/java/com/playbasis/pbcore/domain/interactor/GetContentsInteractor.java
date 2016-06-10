package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.GetContentsForm;
import com.playbasis.pbcore.rest.result.ContentsApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetContentsInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetIdeasInteractor";

  private GetContentsForm getContentsForm;

  @Inject
  public GetContentsInteractor(ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread,
                               RestClient restClient,
                               RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getContentService()
        .getContents(
            restClient.getApiKey(),
            getContentsForm.category,
            getContentsForm.pin,
            getContentsForm.playerId,
            getContentsForm.onlyNewContents,
            getContentsForm.sort,
            getContentsForm.order,
            getContentsForm.offset,
            getContentsForm.limit
        )
        .map(new PBApiErrorCheckFunc<ContentsApiResult>());
  }

  public void setGetContentsForm(GetContentsForm getContentsForm) {
    this.getContentsForm = getContentsForm;
  }
}
