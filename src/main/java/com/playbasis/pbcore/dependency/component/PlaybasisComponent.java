/**
 * Copyright (C) 2015 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.core.Playbasis;
import com.playbasis.pbcore.dependency.module.PlaybasisModule;
import com.playbasis.pbcore.dependency.module.ThreadModule;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.view.viewInterface.PBActivityInterface;
import com.playbasis.pbcore.view.viewInterface.PBFragmentInterface;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {PlaybasisModule.class, ThreadModule.class})
public interface PlaybasisComponent {

  void inject(Playbasis playbasis);

  void inject(PBActivityInterface activityInterface);

  void inject(PBFragmentInterface fragmentInterface);

  RestClient restClient();

}
