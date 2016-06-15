package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.controller.PBSharedPreference;
import com.playbasis.pbcore.domain.model.Organization;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.GetStoreOrganizationForm;
import com.playbasis.pbcore.rest.result.StoreOrganizeApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetOrganizationInteractor extends RestInteractor {

  GetStoreOrganizationForm getStoreOrganizationForm;
  PBSharedPreference sharedPreference;

  @Inject
  public GetOrganizationInteractor(ThreadExecutor threadExecutor,
                                   PostExecutionThread postExecutionThread,
                                   RestClient restClient,
                                   PBSharedPreference sharedPreference) {
    super(threadExecutor, postExecutionThread, restClient);

    this.sharedPreference = sharedPreference;
  }

  @Override
  public Observable buildUseCaseObservable() {
    final GetStoreOrganizationForm form = getStoreOrganizationForm;

    if (form.isReloadCache()) {
      List<? extends Organization> organizations = sharedPreference.readOrganizations(form.getKlass(), form.getSaveKey());

      if (organizations != null) {
        return Observable.just(organizations);
      }
    }

    return restClient.getStoreOrganizeService()
        .getStoreOrganize(
            restClient.getApiKey(),
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
