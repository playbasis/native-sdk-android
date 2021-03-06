package com.playbasis.pbcore.domain.interactor.redeem;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.redeem.RedeemGoodsGroupForm;
import com.playbasis.pbcore.rest.result.redeem.RedeemGoodsGroupApiResult;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class RedeemGoodsGroupInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RedeemGoodsCouponInteractor";

  protected RedeemGoodsGroupForm redeemGoodsGroupForm;

  @Inject
  public RedeemGoodsGroupInteractor(PBThreadExecutor threadExecutor,
                                    PBPostExecutionThread postExecutionThread,
                                    RestClient restClient,
                                    RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getRedeemService()
        .redeemGoodsGroup(
            getApiToken(),
            redeemGoodsGroupForm.getPlayerId(),
            redeemGoodsGroupForm.getGroup(),
            redeemGoodsGroupForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<RedeemGoodsGroupApiResult>());
  }

  public void setRedeemGoodsGroupForm(RedeemGoodsGroupForm redeemGoodsGroupForm) {
    this.redeemGoodsGroupForm = redeemGoodsGroupForm;
  }
}
