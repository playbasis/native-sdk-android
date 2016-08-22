package com.playbasis.sdk;

import android.app.Application;

import com.playbasis.pbcore.dependency.component.DaggerPlaybasisComponent;
import com.playbasis.pbcore.dependency.component.PlaybasisComponent;
import com.playbasis.pbcore.dependency.module.PlaybasisModule;
import com.playbasis.pbcore.rest.RestClient;

import javax.inject.Inject;

/**
 * Created by Tar on 6/13/16 AD.
 */
public class Playbasis {

  private static Playbasis playbasis;
  private static PlaybasisComponent playbasisComponent;

  @Inject
  RestClient restClient;

  public static Playbasis instance() {
    if (playbasis == null) {
      playbasis = new Playbasis();

      playbasisComponent.inject(playbasis);
    }

    return playbasis;
  }

  public static void init(Application application) {
    init(application, null, null);
  }

  public static void init(Application application, String apiKey, String apiSecret) {
    playbasisComponent = DaggerPlaybasisComponent.builder()
        .playbasisModule(new PlaybasisModule(application))
        .build();

    Playbasis playbasis = instance();
    playbasis.restClient.setApiKey(apiKey);
    playbasis.restClient.setApiSecret(apiSecret);
  }

  public static PlaybasisComponent getPlaybasisComponent() {
    return playbasisComponent;
  }

}
