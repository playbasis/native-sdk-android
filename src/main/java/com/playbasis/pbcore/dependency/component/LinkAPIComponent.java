package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.LinkModule;
import com.playbasis.sdk.LinkAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { LinkModule.class })
public interface LinkAPIComponent {

  void inject(LinkAPI linkAPI);

}
