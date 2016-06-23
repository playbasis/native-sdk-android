package com.playbasis.pbcore.domain.interactor.content;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.content.GetContentsForm;
import com.playbasis.pbcore.rest.result.content.ContentsApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
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
            getApiKey(),
            getContentsForm.getCategory(),
            getContentsForm.getPin(),
            getContentsForm.getPlayerId(),
            getContentsForm.isOnlyNewContents(),
            getContentsForm.getSort(),
            getContentsForm.getOrder(),
            getContentsForm.getOffset(),
            getContentsForm.getLimit()
        )
        .map(new PBApiErrorCheckFunc<ContentsApiResult>());
  }

  public void setGetContentsForm(GetContentsForm getContentsForm) {
    this.getContentsForm = getContentsForm;
  }
}
