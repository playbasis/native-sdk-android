package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.LiveFeedModule;
import com.playbasis.pbcore.dependency.module.ServiceModule;
import com.playbasis.sdk.LiveFeedAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = {LiveFeedModule.class})
public interface LiveFeedAPIComponent {

  void inject(LiveFeedAPI liveFeedAPI);

}
