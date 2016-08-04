package com.playbasis.pbcore.domain.interactor.content;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.content.CountContentForm;
import com.playbasis.pbcore.rest.result.content.CountContentApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class CountContentInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "CountContentInteractor";

  protected CountContentForm countContentForm;

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
            countContentForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<CountContentApiResult>());
  }

  public void setCountIdeasForm(CountContentForm countContentForm) {
    countContentForm = countContentForm;
  }

}
