package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerRedeemAPIComponent;
import com.playbasis.pbcore.dependency.module.RedeemModule;
import com.playbasis.pbcore.domain.interactor.redeem.RedeemGoodsGroupInteractor;
import com.playbasis.pbcore.domain.interactor.redeem.RedeemGoodsInteractor;
import com.playbasis.pbcore.domain.interactor.redeem.VerifyGoodsGroupInteractor;
import com.playbasis.pbcore.rest.form.redeem.RedeemGoodsForm;
import com.playbasis.pbcore.rest.form.redeem.VerifyGoodsGroupForm;
import com.playbasis.sdk.callback.BasicApiCallback;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

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
  @Inject
  protected VerifyGoodsGroupInteractor verifyGoodsGroupInteractor;

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

  public static void redeem(RedeemForm form, RedeemCallback callback) {
    instance().redeemGoodsInteractor.setRedeemGoodsForm(form);
    instance().redeemGoodsInteractor.execute(new BaseApiSubscriber<>(callback));
  }
  public static void redeemGoodsGroup(RedeemGoodsGroupForm form, RedeemGoodsGroupCallback callback) {
    instance().redeemGoodsGroupInteractor.setRedeemGoodsGroupForm(form);
    instance().redeemGoodsGroupInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void redeemVerification(RedeemVerificationForm form, RedeemVerificationCallback callback) {
    instance().verifyGoodsGroupInteractor.setVerifyGoodsGroupForm(form);
    instance().verifyGoodsGroupInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class RedeemForm extends RedeemGoodsForm {

    public RedeemForm(String goodsId, String playerId) {
      super(goodsId, playerId);
    }
  }

  public static class RedeemGoodsGroupForm extends com.playbasis.pbcore.rest.form.redeem.RedeemGoodsGroupForm {

    public RedeemGoodsGroupForm(String group, String playerId) {
      super(group, playerId);
    }
  }

  public static class RedeemVerificationForm extends VerifyGoodsGroupForm {

    public RedeemVerificationForm(String goodsGroup, String couponCode, String pinCode) {
      super(goodsGroup, couponCode, pinCode);
    }
  }

  public interface RedeemCallback extends BasicApiCallback {

  }

  public interface RedeemGoodsGroupCallback extends BasicApiCallback {

  }

  public interface RedeemVerificationCallback extends BasicApiCallback {

  }
}
