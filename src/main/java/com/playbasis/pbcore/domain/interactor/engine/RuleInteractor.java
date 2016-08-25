package com.playbasis.pbcore.domain.interactor.engine;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.RuleResponse;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.engine.EngineRuleForm;
import com.playbasis.pbcore.rest.result.Engine.RuleApiResult;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class RuleInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RuleInteractor";

  protected EngineRuleForm engineRuleForm;

  @Inject
  public RuleInteractor(PBThreadExecutor threadExecutor,
                        PBPostExecutionThread postExecutionThread,
                        RestClient restClient,
                        RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getEngineService()
        .rule(
            getApiToken(),
            engineRuleForm.getAction(),
            engineRuleForm.getPlayerId(),
            engineRuleForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<RuleApiResult>())
        .map(getResultMapFunction());
  }

  public void setEngineRuleForm(EngineRuleForm engineRuleForm) {
    this.engineRuleForm = engineRuleForm;
  }

  public Func1<RuleApiResult, RuleResponse> getResultMapFunction() {
    return new Func1<RuleApiResult, RuleResponse>() {
      @Override
      public RuleResponse call(RuleApiResult ruleApiResult) {
        return new RuleResponse(
            ruleApiResult.getEventResponse(),
            ruleApiResult.getEventMissionResponse(),
            ruleApiResult.getEventQuestResponse()
        );
      }
    };
  }
}
