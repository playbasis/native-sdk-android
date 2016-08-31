package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.ActionReport;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerActionReportForm;
import com.playbasis.pbcore.rest.result.player.ActionReportApiResult;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerActionReportInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RequestOTPCodeInteractor";

  protected GetPlayerActionReportForm getPlayerActionReportForm;

  @Inject
  public GetPlayerActionReportInteractor(PBThreadExecutor threadExecutor,
                                         PBPostExecutionThread postExecutionThread,
                                         RestClient restClient,
                                         RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .actionReport(
            getPlayerActionReportForm.getPlayerId(),
            getApiKey(),
            getPlayerActionReportForm.getFields())
        .map(new PBApiErrorCheckFunc<ActionReportApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetPlayerActionReportForm(GetPlayerActionReportForm getPlayerActionReportForm) {
    this.getPlayerActionReportForm = getPlayerActionReportForm;
  }

  public Func1<ActionReportApiResult, List<? extends ActionReport>> getResultMapFunction() {
    return new Func1<ActionReportApiResult, List<? extends ActionReport>>() {
      @Override
      public List<? extends ActionReport> call(ActionReportApiResult actionReportApiResult) {
        return ActionReport.createActionReport(actionReportApiResult.response);
      }
    };
  }
}
