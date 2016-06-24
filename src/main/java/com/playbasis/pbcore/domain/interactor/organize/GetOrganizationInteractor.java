package com.playbasis.pbcore.domain.interactor.organize;

import com.playbasis.pbcore.domain.controller.PBSharedPreference;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Organization;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.organize.GetStoreOrganizationForm;
import com.playbasis.pbcore.rest.result.organize.StoreOrganizeApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetOrganizationInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetOrganizationInteractor";

  GetStoreOrganizationForm getStoreOrganizationForm;
  PBSharedPreference sharedPreference;

  @Inject
  public GetOrganizationInteractor(ThreadExecutor threadExecutor,
                                   PostExecutionThread postExecutionThread,
                                   RestClient restClient,
                                   RequestTokenInteractor requestTokenInteractor,
                                   PBSharedPreference sharedPreference) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

    this.sharedPreference = sharedPreference;
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    final GetStoreOrganizationForm form = getStoreOrganizationForm;

    if (form.isReloadCache()) {
      List<? extends Organization> organizations = sharedPreference.readOrganizations(form.getKlass(), form.getSaveKey());

      if (organizations != null) {
        return Observable.just(organizations);
      }
    }

    return restClient.getStoreOrganizeService()
        .getStoreOrganize(
            getApiKey(),
            form.getOrganizationId()
        )
        .map(new PBApiErrorCheckFunc<StoreOrganizeApiResult>())
        .map(new Func1<StoreOrganizeApiResult, List<? extends Organization>>() {
          @Override
          public List<? extends Organization> call(StoreOrganizeApiResult storeOrganizeApiResult) {
            if (storeOrganizeApiResult == null) {
              return null;
            }

            List<? extends Organization> organizations = storeOrganizeApiResult.getOrganizations(form.getKlass());
            sharedPreference.writeOrganizations(organizations, form.getSaveKey());

            return organizations;
          }
        });
  }

  public void setGetStoreOrganizationForm(GetStoreOrganizationForm getStoreOrganizationForm) {
    this.getStoreOrganizationForm = getStoreOrganizationForm;
  }
}
