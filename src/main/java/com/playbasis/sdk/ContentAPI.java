package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerContentAPIComponent;
import com.playbasis.pbcore.dependency.module.ContentModule;
import com.playbasis.pbcore.domain.interactor.content.ContentFeedbackInteractor;
import com.playbasis.pbcore.domain.interactor.content.CountContentInteractor;
import com.playbasis.pbcore.domain.interactor.content.DislikeContentInteractor;
import com.playbasis.pbcore.domain.interactor.content.GetContentsInteractor;
import com.playbasis.pbcore.domain.interactor.content.LikeContentInteractor;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class ContentAPI {

  private static ContentAPI contentAPI;

  @Inject
  protected GetContentsInteractor getContentsInteractor;
  @Inject
  protected CountContentInteractor countContentInteractor;
  @Inject
  protected ContentFeedbackInteractor contentFeedbackInteractor;
  @Inject
  protected LikeContentInteractor likeContentInteractor;
  @Inject
  protected DislikeContentInteractor dislikeContentInteractor;


  public static ContentAPI instance() {
    if (contentAPI == null) {
      contentAPI = new ContentAPI();

      DaggerContentAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .contentModule(new ContentModule())
          .build()
          .inject(contentAPI);
    }

    return contentAPI;
  }
}
