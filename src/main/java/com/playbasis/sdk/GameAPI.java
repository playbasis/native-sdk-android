package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerGameAPIComponent;
import com.playbasis.pbcore.dependency.module.GameModule;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class GameAPI {

  private static GameAPI gameAPI;

  public static GameAPI instance() {
    if (gameAPI == null) {
      gameAPI = new GameAPI();

      DaggerGameAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .gameModule(new GameModule())
          .build()
          .inject(gameAPI);
    }

    return gameAPI;
  }
}
