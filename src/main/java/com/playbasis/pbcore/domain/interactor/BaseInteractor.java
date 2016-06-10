package com.playbasis.pbcore.domain.interactor;

import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

/**
 * Created by Tar on 4/20/16 AD.
 */
public abstract class BaseInteractor extends com.smartsoftasia.ssalibrary.domain.interactor.UseCase {

  protected BaseInteractor(ThreadExecutor threadExecutor,
                           PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
  }

}
