package com.playbasis.pbcore.domain.interactor.goods;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Goods;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.goods.GetGoodsListForm;
import com.playbasis.pbcore.rest.result.goods.GoodsListApiResult;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetGoodsListInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetGoodsListInteractor";

  protected GetGoodsListForm getGoodsListForm;

  @Inject
  public GetGoodsListInteractor(PBThreadExecutor threadExecutor,
                                PBPostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getGoodsService()
        .getGoods(
            getApiKey(),
            getGoodsListForm.getPlayerId(),
            getGoodsListForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<GoodsListApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetGoodsListForm(GetGoodsListForm getGoodsListForm) {
    this.getGoodsListForm = getGoodsListForm;
  }

  public Func1<GoodsListApiResult, List<? extends Goods>> getResultMapFunction() {
    return new Func1<GoodsListApiResult, List<? extends Goods>>() {
      @Override
      public List<? extends Goods> call(GoodsListApiResult goodsListApiResult) {
        return Goods.createGoods(goodsListApiResult.getGoodsResponses());
      }
    };
  }
}
