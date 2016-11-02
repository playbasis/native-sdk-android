package com.playbasis.pbcore.domain.interactor.generic;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.generic.GenericForm;
import com.playbasis.pbcore.rest.result.generic.GenericApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GenericGetInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GenericGetInteractor";

  protected GenericForm genericForm;

  @Inject
  public GenericGetInteractor(PBThreadExecutor threadExecutor,
                              PBPostExecutionThread postExecutionThread,
                              RestClient restClient,
                              RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getGenericService()
        .get(
            genericForm.getUrl(),
            getApiKey(),
            genericForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<GenericApiResult>());
  }

  public void setGenericForm(GenericForm genericForm) {
    this.genericForm = genericForm;
  }
}
