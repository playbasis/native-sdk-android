package com.playbasis.pbcore.domain.interactor.quest;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Mission;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.quest.GetMissionInfoForm;
import com.playbasis.pbcore.rest.result.quest.MissionInfoApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetMissionInfoInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetMissionInfoInteractor";

  protected GetMissionInfoForm getMissionInfoForm;

  @Inject
  public GetMissionInfoInteractor(ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread,
                                  RestClient restClient,
                                  RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getQuestService()
        .getMissionDetail(
            getMissionInfoForm.getQuestId(),
            getMissionInfoForm.getMissionId(),
            getApiKey()
        )
        .map(new PBApiErrorCheckFunc<MissionInfoApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetQuestListForm(GetMissionInfoForm getMissionInfoForm) {
    this.getMissionInfoForm = getMissionInfoForm;
  }

  public Func1<MissionInfoApiResult, ? extends Mission> getResultMapFunction() {
    return new Func1<MissionInfoApiResult, Mission>() {
      @Override
      public Mission call(MissionInfoApiResult missionInfoApiResult) {
        return new Mission(missionInfoApiResult.getMissionResponse());
      }
    };
  }
}
