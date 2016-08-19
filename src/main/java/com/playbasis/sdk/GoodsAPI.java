package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerGoodsAPIComponent;
import com.playbasis.pbcore.dependency.module.GoodsModule;
import com.playbasis.pbcore.domain.interactor.goods.GetGoodsInfoInteractor;
import com.playbasis.pbcore.domain.interactor.goods.GetGoodsListInteractor;
import com.playbasis.pbcore.domain.interactor.goods.RedeemGoodsCouponInteractor;
import com.playbasis.pbcore.domain.interactor.goods.VerifyGoodsCouponInteractor;

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
}
