package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Goods;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerGoodsForm;
import com.playbasis.pbcore.rest.result.player.GetPlayerGoodsApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerAllGoodsInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerAllBadgesInteractor";

  protected GetPlayerGoodsForm getPlayerGoodsForm;

  @Inject
  public GetPlayerAllGoodsInteractor(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread,
                                     RestClient restClient,
                                     RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .getPlayerAllGoods(
            getPlayerGoodsForm.getPlayerId(),
            getApiKey()
        )
        .map(new PBApiErrorCheckFunc<GetPlayerGoodsApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetPlayerGoodsForm(GetPlayerGoodsForm getPlayerGoodsForm) {
    this.getPlayerGoodsForm = getPlayerGoodsForm;
  }

  public Func1<GetPlayerGoodsApiResult, List<? extends Goods>> getResultMapFunction() {
    return new Func1<GetPlayerGoodsApiResult, List<? extends Goods>>() {
      @Override
      public List<? extends Goods> call(GetPlayerGoodsApiResult getPlayerBadgesApiResult) {
        return Goods.createGoods(getPlayerBadgesApiResult.getGoodsResponse());
      }
    };
  }
}
