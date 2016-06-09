package com.playbasis.pbcore.presenter;

import com.playbasis.pbcore.domain.interactor.interactorInterface.NoInternetConnectionInterface;
import com.playbasis.pbcore.view.viewInterface.NoInternetConnectionViewInterface;
import com.smartsoftasia.ssalibrary.presenter.Presenter;

import rx.subjects.PublishSubject;

/**
 * Created by Tar on 4/20/16 AD.
 */
public abstract class PBPresenter implements Presenter {

  protected NoInternetConnectionViewInterface noInternetConnectionViewInterfaceListener;

  @Override
  public void create() {

  }

  @Override
  public void start() {

  }

  @Override
  public void resume() {

  }

  @Override
  public void pause() {

  }

  @Override
  public void destroy() {

  }

  public void setNoInternetConnectionViewInterfaceListener(NoInternetConnectionViewInterface noInternetConnectionViewInterfaceListener) {
    this.noInternetConnectionViewInterfaceListener = noInternetConnectionViewInterfaceListener;
  }

  protected NoInternetConnectionInterface noInternetConnectionInterface = new NoInternetConnectionInterface() {
    @Override
    public PublishSubject<Integer> noInternetConnection(Throwable throwable) {
      if (noInternetConnectionViewInterfaceListener != null){
        return noInternetConnectionViewInterfaceListener.noInternetConnection(throwable);
      }else{
        PublishSubject<Integer> choice = PublishSubject.create();
        choice.onError(throwable);
        return choice;
      }
    }
  };
}
