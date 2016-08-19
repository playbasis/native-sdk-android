package com.playbasis.pbcore.domain.interactor.content;

import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.content.ContentFeedbackForm;
import com.playbasis.pbcore.rest.result.content.ContentOpinionApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class ContentFeedbackInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "ContentFeedbackInteractor";

  protected ContentFeedbackForm contentFeedbackForm;

  @Inject
  public ContentFeedbackInteractor(PBThreadExecutor threadExecutor,
                                   PBPostExecutionThread postExecutionThread,
                                   RestClient restClient,
                                   RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getContentService().sendContentFeedback(
        getApiToken(),
        contentFeedbackForm.getNodeId(),
        contentFeedbackForm.getPlayerId(),
        contentFeedbackForm.getComment(),
        contentFeedbackForm.getFields()
    ).map(new PBApiErrorCheckFunc<ContentOpinionApiResult>());
  }

  public void setContentFeedbackForm(ContentFeedbackForm contentFeedbackForm) {
    this.contentFeedbackForm = contentFeedbackForm;
  }
}
