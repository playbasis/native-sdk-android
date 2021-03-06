package com.playbasis.pbcore.domain.interactor.goods;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Goods;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.goods.GetGoodsInfoForm;
import com.playbasis.pbcore.rest.result.goods.GoodsInfoApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetGoodsInfoInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetGoodsInfoInteractor";

  protected GetGoodsInfoForm getGoodsInfoForm;

  @Inject
  public GetGoodsInfoInteractor(PBThreadExecutor threadExecutor,
                                PBPostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getGoodsService()
        .getGoodsDetail(
            getGoodsInfoForm.getGoodsId(),
            getApiKey(),
            getGoodsInfoForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<GoodsInfoApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetGoodsInfoForm(GetGoodsInfoForm getGoodsInfoForm) {
    this.getGoodsInfoForm = getGoodsInfoForm;
  }

  public Func1<GoodsInfoApiResult, ? extends Goods> getResultMapFunction() {
    return new Func1<GoodsInfoApiResult, Goods>() {
      @Override
      public Goods call(GoodsInfoApiResult goodsInfoApiResult) {
        Goods goods = new Goods();
        goods.update(goodsInfoApiResult.getGoodsResponse());
        return goods;
      }
    };
  }
}
