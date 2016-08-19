package com.playbasis.pbcore.dependency.module;

import android.content.Context;

import com.playbasis.pbcore.domain.executor.PBJobExecutor;
import com.playbasis.pbcore.domain.executor.PBPBUiTheadHandlerImpl;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.executor.PBUIThread;
import com.playbasis.pbcore.domain.executor.PBUiThreadHandler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ThreadModule {

    @Provides
    @Singleton
    PBThreadExecutor provideThreadExecutor(PBJobExecutor PBJobExecutor) {
        return PBJobExecutor;
    }

    @Provides
    @Singleton
    PBPostExecutionThread providePostExecutionThread(PBUIThread PBUIThread) {
        return PBUIThread;
    }

    @Provides
    @Singleton
    PBUiThreadHandler provideUiThreadHandler(Context context) {
        return new PBPBUiTheadHandlerImpl(context);
    }
}
