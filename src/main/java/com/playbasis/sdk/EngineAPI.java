package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerEngineAPIComponent;
import com.playbasis.pbcore.dependency.module.EngineModule;
import com.playbasis.pbcore.domain.interactor.engine.RuleInteractor;
import com.playbasis.pbcore.domain.model.RuleResponse;
import com.playbasis.pbcore.rest.form.engine.EngineRuleForm;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class EngineAPI {

  private static EngineAPI engineAPI;

  @Inject
  protected RuleInteractor ruleInteractor;

  public static EngineAPI instance() {
    if (engineAPI == null) {
      engineAPI = new EngineAPI();

      DaggerEngineAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .engineModule(new EngineModule())
          .build()
          .inject(engineAPI);
    }

    return engineAPI;
  }

  public static void rule(RuleForm form, final RuleCallback callback) {
    instance().ruleInteractor.setEngineRuleForm(form);
    instance().ruleInteractor.execute(new BaseApiSubscriber<RuleResponse>(callback));
  }

  public static class RuleForm extends EngineRuleForm {

    public RuleForm(String action, String playerId) {
      super(action, playerId);
    }
  }

  public interface RuleCallback extends BasicApiCallbackWithResult<RuleResponse> {

  }
}
