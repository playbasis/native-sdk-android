package com.playbasis.pbcore.domain.interactor.point;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.RemainingPoint;
import com.playbasis.pbcore.domain.model.Transaction;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.point.ApproveTransactionCustomPointForm;
import com.playbasis.pbcore.rest.form.point.RetrieveRemainingPointsForm;
import com.playbasis.pbcore.rest.result.point.RemainingPointApiResult;
import com.playbasis.pbcore.rest.result.point.TransactionCustomPointApiResult;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Nott on 16/11/2559.
 * playbasis-sdk-android-project
 */

public class ApproveTransactionInteractor extends PlayBasisApiInteractor {
  public static final String TAG = "GetRemainingPointsInter";

  private ApproveTransactionCustomPointForm form;

  @Inject
  public ApproveTransactionInteractor(PBThreadExecutor threadExecutor,
                                      PBPostExecutionThread postExecutionThread,
                                      RestClient restClient,
                                      RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPointService()
        .pointApproval(getApiToken(), form.getTransaction(), form.getIsApprove())
        .map(new PBApiErrorCheckFunc<TransactionCustomPointApiResult>())
        .map(getResultFunction());
  }

  public void setForm(ApproveTransactionCustomPointForm form) {
    this.form = form;
  }

  public Func1<TransactionCustomPointApiResult, List<? extends Transaction>> getResultFunction() {
    return new Func1<TransactionCustomPointApiResult, List<? extends Transaction>>() {
      @Override
      public List<? extends Transaction> call(TransactionCustomPointApiResult response) {
        return Transaction.createTransactions(response.response);
      }
    };
  }
}
