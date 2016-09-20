package com.playbasis.pbcore.domain.interactor.Link;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.Link.GenerateLinkForm;
import com.playbasis.pbcore.rest.result.Link.GenerateLinkApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GenerateLinkInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RuleInteractor";

  protected GenerateLinkForm generateLinkForm;

  @Inject
  public GenerateLinkInteractor(PBThreadExecutor threadExecutor,
                                PBPostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getLinkService()
        .generate(
            getApiToken(),
            generateLinkForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<GenerateLinkApiResult>());
  }

  public void setGenerateLinkForm(GenerateLinkForm generateLinkForm) {
    this.generateLinkForm = generateLinkForm;
  }
}
