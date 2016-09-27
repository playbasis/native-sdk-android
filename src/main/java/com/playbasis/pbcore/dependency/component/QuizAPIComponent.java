package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.QuizModule;
import com.playbasis.sdk.QuizAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { QuizModule.class })
public interface QuizAPIComponent {

  void inject(QuizAPI quizAPI);

}
