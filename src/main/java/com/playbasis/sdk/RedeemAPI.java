package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerRedeemAPIComponent;
import com.playbasis.pbcore.dependency.module.RedeemModule;
import com.playbasis.pbcore.domain.interactor.redeem.RedeemGoodsGroupInteractor;
import com.playbasis.pbcore.domain.interactor.redeem.RedeemGoodsInteractor;

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
}
