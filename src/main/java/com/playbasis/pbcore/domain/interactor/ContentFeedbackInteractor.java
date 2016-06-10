package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.ContentFeedbackForm;
import com.playbasis.pbcore.rest.result.ContentOpinionApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class ContentFeedbackInteractor extends PlayBasisApiInteractor {

  private ContentFeedbackForm form;

  @Inject
  public ContentFeedbackInteractor(ThreadExecutor threadExecutor,
                                   PostExecutionThread postExecutionThread,
                                   RestClient restClient,
                                   RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getContentService().sendContentFeedback(
        token.token,
        form.getNodeId(),
        form.getPlayerId(),
        form.getComment(),
        form.getKey(),
        form.getValue()
    ).map(new PBApiErrorCheckFunc<ContentOpinionApiResult>());
  }

  public void setContentFeedbackForm(ContentFeedbackForm form) {
    this.form = form;
  }
}
