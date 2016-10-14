package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.SettingModule;
import com.playbasis.sdk.SettingAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { SettingModule.class })
public interface SettingAPIComponent {

  void inject(SettingAPI settingAPI);

}
