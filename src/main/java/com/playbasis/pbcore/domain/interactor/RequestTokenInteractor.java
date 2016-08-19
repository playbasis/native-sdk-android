package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.controller.PBSharedPreference;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.Token;
import com.playbasis.pbcore.rest.result.RequestTokenApiResult;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;

import java.util.Date;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class RequestTokenInteractor extends RestInteractor {

  protected PBSharedPreference sharedPreference;

  @Inject
  public RequestTokenInteractor(PBThreadExecutor threadExecutor,
                                PBPostExecutionThread postExecutionThread,
                                RestClient restClient,
                                PBSharedPreference sharedPreference) {
    super(threadExecutor, postExecutionThread, restClient);
    this.sharedPreference = sharedPreference;
  }

  @Override
  public Observable buildUseCaseObservable() {
    final Token token = sharedPreference.readToken();

    Date now = new Date();
    if (token != null && now.before(token.expiredDate)) {
      return Observable.just(token);
    } else {
      sharedPreference.writeToken(null);

      return restClient.getTokenService()
          .getToken(
              restClient.getApiKey(),
              restClient.getApiSecret()
          ).map(new Func1<RequestTokenApiResult, Token>() {
            @Override
            public Token call(RequestTokenApiResult requestTokenApiResult) {
              if (requestTokenApiResult != null) {
                sharedPreference.writeToken(requestTokenApiResult.response);
                return requestTokenApiResult.response;
              } else {
                return null;
              }
            }
          });
    }
  }

}
