package com.playbasis.pbcore.domain.interactor.organize;

import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Organization;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.organize.GetStoreOrganizationForm;
import com.playbasis.pbcore.rest.result.organize.StoreOrganizeApiResult;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetOrganizationInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetOrganizationInteractor";

  protected GetStoreOrganizationForm getStoreOrganizationForm;

  @Inject
  public GetOrganizationInteractor(PBThreadExecutor threadExecutor,
                                   PBPostExecutionThread postExecutionThread,
                                   RestClient restClient,
                                   RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getStoreOrganizeService()
        .getStoreOrganize(
            getApiKey(),
            getStoreOrganizationForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<StoreOrganizeApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetStoreOrganizationForm(GetStoreOrganizationForm getStoreOrganizationForm) {
    this.getStoreOrganizationForm = getStoreOrganizationForm;
  }

  public Func1<StoreOrganizeApiResult, List<? extends Organization>> getResultMapFunction() {
    return new Func1<StoreOrganizeApiResult, List<? extends Organization>>() {
      @Override
      public List<? extends Organization> call(StoreOrganizeApiResult storeOrganizeApiResult) {
        return Organization.createOrganizes(storeOrganizeApiResult.getOrganizationResponse());
      }
    };
  }
}
