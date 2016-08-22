package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerStoreOrganizeAPIComponent;
import com.playbasis.pbcore.dependency.module.OrganizationModule;
import com.playbasis.pbcore.domain.interactor.organize.GetOrganizationInteractor;
import com.playbasis.pbcore.domain.model.Organization;
import com.playbasis.pbcore.rest.form.organize.GetStoreOrganizationForm;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class StoreOrganizeAPI {

  private static StoreOrganizeAPI storeOrganizeAPI;

  @Inject
  protected GetOrganizationInteractor getOrganizationInteractor;

  public static StoreOrganizeAPI instance() {
    if (storeOrganizeAPI == null) {
      storeOrganizeAPI = new StoreOrganizeAPI();

      DaggerStoreOrganizeAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .organizationModule(new OrganizationModule())
          .build()
          .inject(storeOrganizeAPI);
    }

    return storeOrganizeAPI;
  }

  public static void listNodes(ListNodesForm form, ListNodesCallback callback) {
    instance().getOrganizationInteractor.setGetStoreOrganizationForm(form);
    instance().getOrganizationInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class ListNodesForm extends GetStoreOrganizationForm {

  }

  public interface ListNodesCallback extends BasicApiCallbackWithResult<List<Organization>> {

  }
}
