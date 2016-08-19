package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.PlayerModule;
import com.playbasis.sdk.PlayerAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { PlayerModule.class })
public interface PlayerAPIComponent {

  void inject(PlayerAPI playerAPI);

}
