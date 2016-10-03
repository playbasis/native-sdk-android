package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerMerchantAPIComponent;
import com.playbasis.pbcore.dependency.module.MerchantModule;
import com.playbasis.pbcore.domain.interactor.merchant.AvailableBranchForGoodsGroupInteractor;
import com.playbasis.pbcore.domain.interactor.merchant.MerchantCouponVerificationInteractor;
import com.playbasis.pbcore.domain.interactor.merchant.MerchantRedeemCouponInteractor;
import com.playbasis.pbcore.domain.model.Merchant;
import com.playbasis.pbcore.rest.form.merchant.RedeemCouponForm;
import com.playbasis.pbcore.rest.form.merchant.CouponVerificationForm;
import com.playbasis.sdk.callback.BasicApiCallback;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class MerchantAPI {

  private static MerchantAPI merchantAPI;

  @Inject
  protected AvailableBranchForGoodsGroupInteractor availableBranchForGoodsGroupInteractor;
  @Inject
  protected MerchantCouponVerificationInteractor merchantCouponVerificationInteractor;
  @Inject
  protected MerchantRedeemCouponInteractor merchantRedeemCouponInteractor;

  public static MerchantAPI instance() {
    if (merchantAPI == null) {
      merchantAPI = new MerchantAPI();

      DaggerMerchantAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .merchantModule(new MerchantModule())
          .build()
          .inject(merchantAPI);
    }

    return merchantAPI;
  }

  public static void availableBranchGoodsGroup(AvailableBranchForGoodsGroupForm form, final AvailableBranchForGoodsGroupCallback callback) {
    instance().availableBranchForGoodsGroupInteractor.setAvailableBranchForGoodsGroupForm(form);
    instance().availableBranchForGoodsGroupInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void merchantCouponVerification(MerchantCouponVerificationForm form, MerchantCouponVerificationCallback callback) {
    instance().merchantCouponVerificationInteractor.setCouponVerificationForm(form);
    instance().merchantCouponVerificationInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void merchantRedeemCoupon(MerchantRedeemCouponForm form, MerchantRedeemCouponCallback callback) {
    instance().merchantRedeemCouponInteractor.setRedeemCouponForm(form);
    instance().merchantRedeemCouponInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class AvailableBranchForGoodsGroupForm extends com.playbasis.pbcore.rest.form.merchant.AvailableBranchForGoodsGroupForm {

    public AvailableBranchForGoodsGroupForm(String goodsGroup) {
      super(goodsGroup);
    }
  }

  public static class MerchantCouponVerificationForm extends CouponVerificationForm {

    public MerchantCouponVerificationForm(String goodsGroup, String couponCode) {
      super(goodsGroup, couponCode);
    }
  }

  public static class MerchantRedeemCouponForm extends RedeemCouponForm {

    public MerchantRedeemCouponForm(String goodsGroup, String couponCode) {
      super(goodsGroup, couponCode);
    }
  }

  public interface AvailableBranchForGoodsGroupCallback extends BasicApiCallbackWithResult<List<Merchant>> {

  }

  public interface MerchantCouponVerificationCallback extends BasicApiCallback {

  }

  public interface MerchantRedeemCouponCallback extends BasicApiCallback {

  }
}
