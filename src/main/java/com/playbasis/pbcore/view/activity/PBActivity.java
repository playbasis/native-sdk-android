package com.playbasis.pbcore.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.playbasis.pbcore.presenter.PBPresenter;
import com.smartsoftasia.ssalibrary.bus.ApplicationBus;

import javax.inject.Inject;

/**
 * Created by Tar on 4/20/16 AD.
 */
public abstract class PBActivity extends com.smartsoftasia.ssalibrary.view.activity.BaseActivity {

  @Inject
  protected ApplicationBus applicationBus;
  protected PBPresenter basePresenter;

  @Override
  protected void beforeLoadContentView(Bundle savedInstanceState) {
    super.beforeLoadContentView(savedInstanceState);
    initializeInjector();
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (basePresenter != null) {
      basePresenter.create();
    }
  }

  @Override
  protected void onStart() {
    super.onStart();

    if (basePresenter != null) {
      basePresenter.start();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    if (applicationBus != null) {
      applicationBus.register(this);
    }

    if (basePresenter != null) {
      basePresenter.resume();
    }

  }

  @Override
  protected void onPause() {
    super.onPause();

    if (applicationBus != null) {
      applicationBus.unregister(this);
    }

    if (basePresenter != null) {
      basePresenter.pause();
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    if (basePresenter != null) {
      basePresenter.destroy();
    }
  }

  protected void initializeInjector() {

  }
}
