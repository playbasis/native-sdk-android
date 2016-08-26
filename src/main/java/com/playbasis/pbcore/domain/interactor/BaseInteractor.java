package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class BaseInteractor {

  private final PBThreadExecutor threadExecutor;
  private final PBPostExecutionThread postExecutionThread;
  Observable observable;
  private Subscription subscription = Subscriptions.empty();

  protected BaseInteractor(PBThreadExecutor threadExecutor,
                           PBPostExecutionThread postExecutionThread) {
    this.threadExecutor = threadExecutor;
    this.postExecutionThread = postExecutionThread;
  }

  protected abstract Observable buildUseCaseObservable();

  @SuppressWarnings("unchecked")
  public void execute(Subscriber UseCaseSubscriber) {
    this.subscription = this.buildUseCaseObservable().subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler()).subscribe(UseCaseSubscriber);
  }

  public void unsubscribe() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
