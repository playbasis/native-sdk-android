/**
 * Copyright (C) 2015 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package com.playbasis.pbcore.dependency.component;

import android.content.Context;

import com.playbasis.pbcore.dependency.module.PlaybasisModule;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.executor.PBUiThreadHandler;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.view.viewInterface.PBActivityInterface;
import com.playbasis.pbcore.view.viewInterface.PBFragmentInterface;
import com.playbasis.sdk.Playbasis;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton
@Component(modules = {
    PlaybasisModule.class
})
public interface PlaybasisComponent {

  void inject(Playbasis playbasis);

  void inject(PBActivityInterface activityInterface);

  void inject(PBFragmentInterface fragmentInterface);

  RestClient restClient();

  Context context();

  PBThreadExecutor threadExecutor();

  PBPostExecutionThread postExecutionThread();

  PBUiThreadHandler threadHandler();

  RequestTokenInteractor requestTokenInteractor();
}
