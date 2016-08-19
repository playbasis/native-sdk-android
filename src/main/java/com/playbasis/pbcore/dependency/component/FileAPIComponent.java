package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.FileModule;
import com.playbasis.sdk.FileAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { FileModule.class })
public interface FileAPIComponent {

  void inject(FileAPI fileAPI);

}
