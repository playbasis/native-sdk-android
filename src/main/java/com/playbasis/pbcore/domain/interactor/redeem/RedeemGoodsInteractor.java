package com.playbasis.pbcore.domain.interactor.redeem;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.redem.RedeemGoodsForm;
import com.playbasis.pbcore.rest.result.redeem.RedeemGoodsApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class RedeemGoodsInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RedeemGoodsCouponInteractor";

  protected RedeemGoodsForm redeemGoodsForm;

  @Inject
  public RedeemGoodsInteractor(ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread,
                               RestClient restClient,
                               RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getRedeemService()
        .redeemGoods(
            getApiToken(),
            redeemGoodsForm.getPlayerId(),
            redeemGoodsForm.getGoodsId(),
            redeemGoodsForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<RedeemGoodsApiResult>());
  }

  public void setRedeemGoodsForm(RedeemGoodsForm redeemGoodsForm) {
    this.redeemGoodsForm = redeemGoodsForm;
  }
}
