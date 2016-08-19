package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.QuestModule;
import com.playbasis.sdk.QuestAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { QuestModule.class })
public interface QuestAPIComponent {

  void inject(QuestAPI questAPI);

}
