package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerQuizAPIComponent;
import com.playbasis.pbcore.dependency.module.QuizModule;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class QuizAPI {

  private static QuizAPI quizAPI;

  public static QuizAPI instance() {
    if (quizAPI == null) {
      quizAPI = new QuizAPI();

      DaggerQuizAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .quizModule(new QuizModule())
          .build()
          .inject(quizAPI);
    }

    return quizAPI;
  }
}
