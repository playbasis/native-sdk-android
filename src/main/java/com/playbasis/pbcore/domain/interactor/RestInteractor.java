package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.interactor.interactorInterface.NoInternetConnectionInterface;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public abstract class RestInteractor extends BaseInteractor {

  protected RestClient restClient;

  protected NoInternetConnectionInterface noInternetConnectionInterface;

  public RestInteractor(PBThreadExecutor threadExecutor,
                        PBPostExecutionThread postExecutionThread,
                        RestClient restClient) {
    super(threadExecutor, postExecutionThread);
    this.restClient = restClient;
  }

  public Func1<Observable<? extends Throwable>, Observable<?>> retryWhenFunc1 = new Func1<Observable<? extends Throwable>, Observable<?>>() {
    @Override
    public Observable<?> call(Observable<? extends Throwable> observable) {
      return observable.flatMap(new Func1<Throwable, Observable<?>>() {
        @Override
        public Observable<?> call(final Throwable throwable) {
          if (noInternetConnectionInterface != null && (throwable instanceof IOException || throwable instanceof SocketTimeoutException || throwable instanceof UnknownHostException)) {
            return noInternetConnectionInterface.noInternetConnection(throwable);
          } else {
            return Observable.error(throwable);
          }
        }
      });
    }
  };

  public void setNoInternetConnectionInterfaceListener(NoInternetConnectionInterface noInternetConnectionInterface) {
    this.noInternetConnectionInterface = noInternetConnectionInterface;
  }
}
