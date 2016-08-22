package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerGoodsAPIComponent;
import com.playbasis.pbcore.dependency.module.GoodsModule;
import com.playbasis.pbcore.domain.interactor.goods.GetGoodsInfoInteractor;
import com.playbasis.pbcore.domain.interactor.goods.GetGoodsListInteractor;
import com.playbasis.pbcore.domain.interactor.goods.RedeemGoodsCouponInteractor;
import com.playbasis.pbcore.domain.interactor.goods.VerifyGoodsCouponInteractor;
import com.playbasis.pbcore.domain.model.Goods;
import com.playbasis.pbcore.rest.form.goods.GetGoodsInfoForm;
import com.playbasis.pbcore.rest.form.goods.GetGoodsListForm;
import com.playbasis.pbcore.rest.form.goods.RedeemGoodsCouponForm;
import com.playbasis.pbcore.rest.form.goods.VerifyGoodsCouponForm;
import com.playbasis.sdk.callback.BasicApiCallback;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class GoodsAPI {

  private static GoodsAPI goodsAPI;

  @Inject
  protected GetGoodsInfoInteractor getGoodsInfoInteractor;
  @Inject
  protected GetGoodsListInteractor getGoodsListInteractor;
  @Inject
  protected RedeemGoodsCouponInteractor redeemGoodsCouponInteractor;
  @Inject
  protected VerifyGoodsCouponInteractor verifyGoodsCouponInteractor;

  public static GoodsAPI instance() {
    if (goodsAPI == null) {
      goodsAPI = new GoodsAPI();

      DaggerGoodsAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .goodsModule(new GoodsModule())
          .build()
          .inject(goodsAPI);
    }

    return goodsAPI;
  }

  public static void goodsListInfo(GoodsListInfoForm form, final GoodsListInfoCallback callback) {
    instance().getGoodsListInteractor.setGetGoodsListForm(form);
    instance().getGoodsListInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void goodsInfo(GoodsInfoForm form, GoodsInfoCallback callback) {
    instance().getGoodsInfoInteractor.setGetGoodsInfoForm(form);
    instance().getGoodsInfoInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void CouponCodeVerification(CouponCodeVerification form, CouponCodeVerificationCallback callback) {
    instance().verifyGoodsCouponInteractor.setVerifyGoodsCouponForm(form);
    instance().verifyGoodsCouponInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void CouponCodeVerificationWithRedeem(CouponCodeVerificationWithRedeemForm form, CouponCodeVerificationWithRedeemCallback callback) {
    instance().redeemGoodsCouponInteractor.setRedeemGoodsCouponForm(form);
    instance().redeemGoodsCouponInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class GoodsListInfoForm extends GetGoodsListForm {

  }

  public static class GoodsInfoForm extends GetGoodsInfoForm {

    public GoodsInfoForm(String goodsId) {
      super(goodsId);
    }
  }

  public static class CouponCodeVerification extends VerifyGoodsCouponForm {

    public CouponCodeVerification(String goodsId, String code) {
      super(goodsId, code);
    }
  }

  public static class CouponCodeVerificationWithRedeemForm extends RedeemGoodsCouponForm {

    public CouponCodeVerificationWithRedeemForm(String goodsId, String code, String playerId) {
      super(goodsId, code, playerId);
    }
  }

  public interface GoodsListInfoCallback extends BasicApiCallbackWithResult<List<Goods>> {

  }

  public interface GoodsInfoCallback extends BasicApiCallbackWithResult<Goods> {

  }

  public interface CouponCodeVerificationCallback extends BasicApiCallback {

  }

  public interface CouponCodeVerificationWithRedeemCallback extends BasicApiCallback {

  }
}
