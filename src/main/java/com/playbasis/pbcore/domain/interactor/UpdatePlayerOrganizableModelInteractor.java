package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.model.Organization;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.UpdatePlayerOrganizationForm;
import com.playbasis.pbcore.rest.result.RemovePlayerFromOrganizeApiResult;
import com.playbasis.pbcore.rest.result.UpdatePlayerOrganizationApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.service.PlayerService;
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

  private UpdatePlayerOrganizationForm updatePlayerOrganizationForm;

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
    final PlayerService playerService = restClient.getPlayerService();

    final List<? extends Organization> currentOrganizableModels = form.getCurrentModels();

    if (currentOrganizableModels != null && currentOrganizableModels.size() > 0 && form.isClearExising()) {
      ArrayList<Observable<RemovePlayerFromOrganizeApiResult>> observables = new ArrayList<>();

      for (Organization model : currentOrganizableModels) {
        observables.add(playerService.removePlayerOrganization(
            form.getPlayerId(),
            model.getId(),
            token.token
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
    return restClient.getPlayerService()
        .addPlayerOrganization(
            form.getPlayerId(),
            form.getNewModel().getId(),
            token.token
        ).map(new PBApiErrorCheckFunc<UpdatePlayerOrganizationApiResult>());
  }

  public void setUpdateOrganizationForm(UpdatePlayerOrganizationForm updatePlayerOrganizationForm) {
    this.updatePlayerOrganizationForm = updatePlayerOrganizationForm;
  }

}
