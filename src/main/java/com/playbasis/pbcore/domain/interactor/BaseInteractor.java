package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by Tar on 4/20/16 AD.
 */
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

  /**
   * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
   */
  protected abstract Observable buildUseCaseObservable();

  /**
   * Executes the current use case.
   *
   * @param UseCaseSubscriber The guy who will be listen to the observable build with {@link
   *                          #buildUseCaseObservable()}.
   */
  @SuppressWarnings("unchecked")
  public void execute(Subscriber UseCaseSubscriber) {
    this.subscription = this.buildUseCaseObservable().subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler()).subscribe(UseCaseSubscriber);
  }

  /**
   * Unsubscribes from current {@link Subscription}.
   */
  public void unsubscribe() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
