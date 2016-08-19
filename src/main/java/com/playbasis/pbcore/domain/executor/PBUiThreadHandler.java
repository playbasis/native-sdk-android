package com.playbasis.pbcore.domain.executor;

import android.os.Handler;

/**
 * Created by gregoire barret on 5/13/15.
 * For Perfumist project.
 */
public interface PBUiThreadHandler {

    Handler getMainHandler();

    void post(Runnable r);
}
