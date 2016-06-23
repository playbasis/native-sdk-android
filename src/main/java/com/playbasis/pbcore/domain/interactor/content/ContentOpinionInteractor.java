package com.playbasis.pbcore.domain.interactor.content;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.content.ContentOpinionForm;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

/**
 * Created by Tar on 4/21/16 AD.
 */
public abstract class ContentOpinionInteractor extends PlayBasisApiInteractor {

  protected ContentOpinionForm form;

  public ContentOpinionInteractor(ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread,
                                  RestClient restClient,
                                  RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  public void setContentOpinionForm(ContentOpinionForm form) {
    this.form = form;
  }
}
