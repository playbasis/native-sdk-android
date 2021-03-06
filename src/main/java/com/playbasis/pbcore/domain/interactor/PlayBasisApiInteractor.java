package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.Token;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public abstract class PlayBasisApiInteractor extends RestInteractor {

  protected RequestTokenInteractor requestTokenInteractor;
  protected Token token;

  public PlayBasisApiInteractor(PBThreadExecutor threadExecutor,
                                PBPostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient);
    this.requestTokenInteractor = requestTokenInteractor;
  }

  public abstract Observable buildApiUseCaseObservable();

  @Override
  public Observable buildUseCaseObservable() {
    return requestTokenInteractor.buildUseCaseObservable()
        .retryWhen(retryWhenFunc1)
        .flatMap(new Func1<Token, Observable>() {
          @Override
          public Observable call(Token token) {
            PlayBasisApiInteractor.this.token = token;
            return buildApiUseCaseObservable().retryWhen(retryWhenFunc1);
          }
        });
  }

  protected final String getApiToken() {
    if (token != null) {
      return token.token;
    }

    return null;
  }

  protected final String getApiKey() {
    if (restClient != null) {
      return restClient.getApiKey();
    }

    return null;
  }

}
