package com.playbasis.pbcore.domain.interactor.content;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Content;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.content.GetContentsForm;
import com.playbasis.pbcore.rest.result.content.ContentsApiResult;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetContentsInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetContentsInteractor";

  protected GetContentsForm getContentsForm;

  @Inject
  public GetContentsInteractor(PBThreadExecutor threadExecutor,
                               PBPostExecutionThread postExecutionThread,
                               RestClient restClient,
                               RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getContentService()
        .getContents(
            getApiKey(),
            getContentsForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<ContentsApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetContentsForm(GetContentsForm getContentsForm) {
    this.getContentsForm = getContentsForm;
  }

  public Func1<ContentsApiResult, List<? extends Content>> getResultMapFunction() {
    return new Func1<ContentsApiResult, List<? extends Content>>() {
      @Override
      public List<Content> call(ContentsApiResult contentsApiResult) {
        return Content.createContents(contentsApiResult.getContentResponses());
      }
    };
  }
}
