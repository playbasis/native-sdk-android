package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.CountContentForm;
import com.playbasis.pbcore.rest.result.CountContentApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class CountContentInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "CountContentInteractor";

  private CountContentForm mCountIdeasForm;

  @Inject
  public CountContentInteractor(ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getContentService()
        .countContents(
            getApiKey(),
            mCountIdeasForm.getCategory(),
            mCountIdeasForm.getPin(),
            mCountIdeasForm.getPlayerId(),
            mCountIdeasForm.isGetOnlyNewContent()
        )
        .map(new PBApiErrorCheckFunc<CountContentApiResult>());
  }

  public void setCountIdeasForm(CountContentForm getProjectForm) {
    mCountIdeasForm = getProjectForm;
  }

}
