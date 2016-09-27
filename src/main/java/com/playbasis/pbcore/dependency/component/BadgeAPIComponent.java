package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.BadgeModule;
import com.playbasis.sdk.BadgeAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { BadgeModule.class })
public interface BadgeAPIComponent {

  void inject(BadgeAPI badgeAPI);

}
