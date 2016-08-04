package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Organization;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.UpdatePlayerOrganizationForm;
import com.playbasis.pbcore.rest.result.organize.RemovePlayerFromOrganizeApiResult;
import com.playbasis.pbcore.rest.result.organize.UpdatePlayerOrganizationApiResult;
import com.playbasis.pbcore.rest.service.StoreOrganizeService;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.FuncN;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UpdatePlayerOrganizableModelInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "UpdatePlayerOrganizableModelInteractor";

  protected UpdatePlayerOrganizationForm updatePlayerOrganizationForm;

  @Inject
  public UpdatePlayerOrganizableModelInteractor(ThreadExecutor threadExecutor,
                                                PostExecutionThread postExecutionThread,
                                                RestClient restClient,
                                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    final UpdatePlayerOrganizationForm form = updatePlayerOrganizationForm;
    final StoreOrganizeService storeOrganizeService = restClient.getStoreOrganizeService();

    final List<? extends Organization> currentOrganizableModels = form.getCurrentModels();

    if (currentOrganizableModels != null && currentOrganizableModels.size() > 0 && form.isClearExising()) {
      ArrayList<Observable<RemovePlayerFromOrganizeApiResult>> observables = new ArrayList<>();

      for (Organization model : currentOrganizableModels) {
        observables.add(storeOrganizeService.removePlayerOrganization(
            form.getPlayerId(),
            model.getId(),
            getApiToken()
        ));
      }

      return Observable.zip(observables, new FuncN<RemovePlayerFromOrganizeApiResult>() {
        @Override
        public RemovePlayerFromOrganizeApiResult call(Object... args) {
          return null;
        }
      }).flatMap(new Func1<RemovePlayerFromOrganizeApiResult, Observable<UpdatePlayerOrganizationApiResult>>() {
        @Override
        public Observable<UpdatePlayerOrganizationApiResult> call(RemovePlayerFromOrganizeApiResult removePlayerFromOrganizeApiResult) {
          return buildUpdateOrganizationObservable(form);
        }
      });
    } else {
      return buildUpdateOrganizationObservable(form);
    }
  }

  private Observable<UpdatePlayerOrganizationApiResult> buildUpdateOrganizationObservable(UpdatePlayerOrganizationForm form) {
    return restClient.getStoreOrganizeService()
        .addPlayerOrganization(
            form.getPlayerId(),
            form.getNewModel().getId(),
            getApiToken()
        ).map(new PBApiErrorCheckFunc<UpdatePlayerOrganizationApiResult>());
  }

  public void setUpdateOrganizationForm(UpdatePlayerOrganizationForm updatePlayerOrganizationForm) {
    this.updatePlayerOrganizationForm = updatePlayerOrganizationForm;
  }

}
