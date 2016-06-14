package com.playbasis.pbcore.view.dialog;

import android.os.Bundle;

import com.playbasis.pbcore.presenter.PBPresenter;
import com.smartsoftasia.ssalibrary.bus.ApplicationBus;
import com.smartsoftasia.ssalibrary.view.dialog.BaseDialogFragment;

import javax.inject.Inject;

/**
 * Created by Tar on 6/14/16 AD.
 */
public abstract class PBDialogFragment extends BaseDialogFragment {

  @Inject
  protected ApplicationBus applicationBus;
  protected PBPresenter basePresenter;

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    initializeInjector();

    if (basePresenter != null) {
      basePresenter.create();
    }
  }

  @Override
  public void onStart() {
    super.onStart();

    if (basePresenter != null) {
      basePresenter.start();
    }
  }

  @Override
  public void onResume() {
    super.onResume();

    if (applicationBus != null) {
      applicationBus.register(this);
    }

    if (basePresenter != null) {
      basePresenter.resume();
    }
  }

  @Override
  public void onPause() {
    super.onPause();

    if (applicationBus != null) {
      applicationBus.unregister(this);
    }

    if (basePresenter != null) {
      basePresenter.pause();
    }
  }

  @Override
  public void onDestroy() {
    super.onDestroy();

    if (basePresenter != null) {
      basePresenter.destroy();
    }
  }

  protected void initializeInjector() {

  }
}
