package com.playbasis.pbcore.domain.interactor.campaign;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Campaign;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.campaign.RetrieveCampaignForm;
import com.playbasis.pbcore.rest.result.campaign.RetrieveCampaignApiResult;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class RetrieveCampaignInteractor extends PlayBasisApiInteractor {
  private static final String TAG = "GetGameSetting";

  private RetrieveCampaignForm campaignForm;

  @Inject
  public RetrieveCampaignInteractor(PBThreadExecutor threadExecutor,
                                    PBPostExecutionThread postExecutionThread,
                                    RestClient restClient,
                                    RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getCampaignService().retrieveCampaign(getApiKey(),
        campaignForm.getCampaignName())
        .map(new PBApiErrorCheckFunc<RetrieveCampaignApiResult>())
        .map(getResultMapFunction());
  }

  public void setCampaignForm(RetrieveCampaignForm campaignForm) {
    this.campaignForm = campaignForm;
  }

  public Func1<RetrieveCampaignApiResult, List<Campaign>> getResultMapFunction() {
    return new Func1<RetrieveCampaignApiResult, List<Campaign>>() {
      @Override
      public List<Campaign> call(RetrieveCampaignApiResult response) {
        return Campaign.createCampaigns(response.response);
      }
    };
  }
}
