package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerCompaignAPIComponent;
import com.playbasis.pbcore.dependency.module.CampaignModule;
import com.playbasis.pbcore.domain.interactor.campaign.RetrieveCampaignInteractor;
import com.playbasis.pbcore.domain.model.Campaign;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Nott on 24/11/2559.
 * playbasis-sdk-android-project
 */

public class CampaignAPI {
  private static CampaignAPI campaignAPI;

  @Inject
  RetrieveCampaignInteractor retrieveCampaignInteractor;

  public static CampaignAPI instance() {
    if (campaignAPI == null) {
      campaignAPI = new CampaignAPI();

      DaggerCompaignAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .campaignModule(new CampaignModule())
          .build()
          .inject(campaignAPI);
    }

    return campaignAPI;
  }

  public static void retrieveCampaign(CampaignAPI.RetrieveCampaignForm form, CampaignAPI.RetrieveCampaignCallback callback) {
    instance().retrieveCampaignInteractor.setCampaignForm(form);
    instance().retrieveCampaignInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class RetrieveCampaignForm extends com.playbasis.pbcore.rest.form.campaign.RetrieveCampaignForm {

    public RetrieveCampaignForm(String campaignName) {
      super(campaignName);
    }
  }

  public interface RetrieveCampaignCallback extends BasicApiCallbackWithResult<List<Campaign>> {

  }
}
