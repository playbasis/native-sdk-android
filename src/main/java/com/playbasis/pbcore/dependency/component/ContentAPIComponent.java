package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.ContentModule;
import com.playbasis.sdk.ContentAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { ContentModule.class })
public interface ContentAPIComponent {

  void inject(ContentAPI contentAPI);

}
