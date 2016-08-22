package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerRedeemAPIComponent;
import com.playbasis.pbcore.dependency.module.RedeemModule;
import com.playbasis.pbcore.domain.interactor.redeem.RedeemGoodsGroupInteractor;
import com.playbasis.pbcore.domain.interactor.redeem.RedeemGoodsInteractor;
import com.playbasis.pbcore.rest.form.redem.RedeemGoodsForm;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class RedeemAPI {

  private static RedeemAPI redeemAPI;

  @Inject
  protected RedeemGoodsGroupInteractor redeemGoodsGroupInteractor;
  @Inject
  protected RedeemGoodsInteractor redeemGoodsInteractor;

  public static RedeemAPI instance() {
    if (redeemAPI == null) {
      redeemAPI = new RedeemAPI();

      DaggerRedeemAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .redeemModule(new RedeemModule())
          .build()
          .inject(redeemAPI);
    }

    return redeemAPI;
  }

  public static void Redeem(RedeemForm form, RedeemCallback callback) {
    instance().redeemGoodsInteractor.setRedeemGoodsForm(form);
    instance().redeemGoodsInteractor.execute(new APIDefaultSubscriber<>(callback));
  }
  public static void RedeemGoodsGroup(RedeemGoodsGroupForm form, RedeemGoodsGroupCallback callback) {
    instance().redeemGoodsGroupInteractor.setRedeemGoodsGroupForm(form);
    instance().redeemGoodsGroupInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static class RedeemForm extends RedeemGoodsForm {

    public RedeemForm(String goodsId, String playerId) {
      super(goodsId, playerId);
    }
  }

  public static class RedeemGoodsGroupForm extends com.playbasis.pbcore.rest.form.redem.RedeemGoodsGroupForm {

    public RedeemGoodsGroupForm(String group, String playerId) {
      super(group, playerId);
    }
  }

  public interface RedeemCallback extends BaseApiCallback<Boolean> {

  }

  public interface RedeemGoodsGroupCallback extends BaseApiCallback<Boolean> {

  }
}
