package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.GetPlayerForm;
import com.playbasis.pbcore.rest.result.BasePlayerApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/26/2016 AD.
 */
public abstract class PlayerApiInteractor<T extends BasePlayerApiResult> extends PlayBasisApiInteractor {

  public static final String TAG = "PlayerApiInteractor";

  GetPlayerInteractor getPlayerInteractor;

  public PlayerApiInteractor(ThreadExecutor threadExecutor,
                             PostExecutionThread postExecutionThread,
                             RestClient restClient,
                             RequestTokenInteractor requestTokenInteractor,
                             GetPlayerInteractor getPlayerInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

    this.getPlayerInteractor = getPlayerInteractor;
  }

  public abstract Observable buildUserApiUseCaseObservable();

  @Override
  public Observable buildApiUseCaseObservable() {
    return buildUserApiUseCaseObservable()
        .map(new PBApiErrorCheckFunc<T>())
        .flatMap(new Func1<BasePlayerApiResult, Observable<Player>>() {
      @Override
      public Observable<Player> call(BasePlayerApiResult userApiResult) {
        GetPlayerForm getPlayerForm = new GetPlayerForm(userApiResult.getUserId());

        getPlayerInteractor.setGetPlayerForm(getPlayerForm);
        return getPlayerInteractor.buildUseCaseObservable();
      }
    });
  }
}
