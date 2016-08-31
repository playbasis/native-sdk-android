package com.playbasis.pbcore.domain.interactor.merchant;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Merchant;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.merchant.AvailableBranchForGoodsGroupForm;
import com.playbasis.pbcore.rest.result.merchant.AvailableBranchForGoodsGroupApiResult;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class AvailableBranchForGoodsGroupInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RuleInteractor";

  protected AvailableBranchForGoodsGroupForm availableBranchForGoodsGroupForm;

  @Inject
  public AvailableBranchForGoodsGroupInteractor(PBThreadExecutor threadExecutor,
                                                PBPostExecutionThread postExecutionThread,
                                                RestClient restClient,
                                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getMerchantService()
        .availableBranchGoodsGroup(
            getApiKey(),
            availableBranchForGoodsGroupForm.getGoodsGroup(),
            availableBranchForGoodsGroupForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<AvailableBranchForGoodsGroupApiResult>())
        .map(getResultMapFunction());
  }

  public void setAvailableBranchForGoodsGroupForm(AvailableBranchForGoodsGroupForm availableBranchForGoodsGroupForm) {
    this.availableBranchForGoodsGroupForm = availableBranchForGoodsGroupForm;
  }

  public Func1<AvailableBranchForGoodsGroupApiResult, List<? extends Merchant>> getResultMapFunction() {
    return new Func1<AvailableBranchForGoodsGroupApiResult, List<? extends Merchant>>() {
      @Override
      public List<? extends Merchant> call(AvailableBranchForGoodsGroupApiResult availableBranchGoodsGroupApiResult) {
        return Merchant.createMerchants(availableBranchGoodsGroupApiResult.response);
      }
    };
  }
}
