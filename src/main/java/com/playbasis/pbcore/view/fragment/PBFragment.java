package com.playbasis.pbcore.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.playbasis.pbcore.presenter.PBPresenter;
import com.playbasis.pbcore.view.viewInterface.NoInternetConnectionViewInterface;
import com.smartsoftasia.ssalibrary.bus.ApplicationBus;

import javax.inject.Inject;

/**
 * Created by Tar on 4/20/16 AD.
 */
public abstract class PBFragment extends com.smartsoftasia.ssalibrary.view.fragment.BaseFragment {

  public interface PBFragmentListener {
    void onDisplayProgress(Fragment fragment);

    void onHideProgress(Fragment fragment);

    void onReceiveErrorThrowable(Fragment fragment, Object object, Throwable e);

    NoInternetConnectionViewInterface getNoInternetConnectionViewInterfaceListener(Fragment fragment);
  }

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
