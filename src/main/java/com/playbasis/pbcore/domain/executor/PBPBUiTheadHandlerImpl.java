package com.playbasis.pbcore.domain.executor;

import android.content.Context;
import android.os.Handler;

import javax.inject.Inject;

/**
 * Created by gregoire barret on 5/13/15.
 * For Perfumist project.
 */
public class PBPBUiTheadHandlerImpl implements PBUiThreadHandler {

    public static final String TAG = "PBPBUiTheadHandlerImpl";

    protected Context context;
    private Handler mainHandler;

    @Inject
    public PBPBUiTheadHandlerImpl(Context context) {
        this.context = context;
        mainHandler = new Handler(context.getMainLooper());
    }

    @Override
    public Handler getMainHandler() {
        return mainHandler;
    }

    @Override
    public void post(Runnable r) {
        mainHandler.post(r);
    }
}
