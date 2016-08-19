package com.playbasis.pbcore.domain.interactor.content;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.content.ContentOpinionForm;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;

/**
 * Created by Tar on 4/21/16 AD.
 */
public abstract class ContentOpinionInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "ContentOpinionInteractor";

  protected ContentOpinionForm contentOpinionForm;

  public ContentOpinionInteractor(PBThreadExecutor threadExecutor,
                                  PBPostExecutionThread postExecutionThread,
                                  RestClient restClient,
                                  RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  public void setContentOpinionForm(ContentOpinionForm contentOpinionForm) {
    this.contentOpinionForm = contentOpinionForm;
  }
}
