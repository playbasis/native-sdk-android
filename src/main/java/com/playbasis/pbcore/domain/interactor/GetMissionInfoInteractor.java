package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.GetMissionInfoForm;
import com.playbasis.pbcore.rest.result.MissionInfoApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetMissionInfoInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetIdeasInteractor";

  private GetMissionInfoForm getMissionInfoForm;

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
        .map(new PBApiErrorCheckFunc<MissionInfoApiResult>());
  }

  public void setGetQuestListForm(GetMissionInfoForm getMissionInfoForm) {
    this.getMissionInfoForm = getMissionInfoForm;
  }
}
