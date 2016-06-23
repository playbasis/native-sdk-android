package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.model.Goods;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.GetGoodsListForm;
import com.playbasis.pbcore.rest.result.GoodsListApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetGoodsListInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetIdeasInteractor";

  private GetGoodsListForm getGoodsListForm;

  @Inject
  public GetGoodsListInteractor(ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread,
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
            getGoodsListForm.getTags()
        )
        .map(new PBApiErrorCheckFunc<GoodsListApiResult>())
        .map(new Func1<GoodsListApiResult, ArrayList<Goods>>() {
          @Override
          public ArrayList<Goods> call(GoodsListApiResult getPlayerBadgesApiResult) {
            return Goods.create(getPlayerBadgesApiResult.getGoodsResponses());
          }
        });
  }

  public void setGetGoodsListForm(GetGoodsListForm getGoodsListForm) {
    this.getGoodsListForm = getGoodsListForm;
  }
}
