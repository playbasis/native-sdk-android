package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerContentAPIComponent;
import com.playbasis.pbcore.dependency.module.ContentModule;
import com.playbasis.pbcore.domain.interactor.content.ContentFeedbackInteractor;
import com.playbasis.pbcore.domain.interactor.content.CountContentInteractor;
import com.playbasis.pbcore.domain.interactor.content.DislikeContentInteractor;
import com.playbasis.pbcore.domain.interactor.content.GetContentsInteractor;
import com.playbasis.pbcore.domain.interactor.content.LikeContentInteractor;
import com.playbasis.pbcore.domain.model.Content;
import com.playbasis.pbcore.rest.form.content.ContentFeedbackForm;
import com.playbasis.pbcore.rest.form.content.GetContentsForm;
import com.playbasis.pbcore.rest.result.content.CountContentApiResult;
import com.playbasis.sdk.callback.BaseApiCallback;
import com.playbasis.sdk.callback.BasicApiCallback;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import java.util.List;

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

  public static void retrieveContent(RetrieveContentForm form, final RetrieveContentCallback callback) {
    instance().getContentsInteractor.setGetContentsForm(form);
    instance().getContentsInteractor.execute(new BaseApiSubscriber<List<Content>>(callback) {
      @Override
      public void onCompleted() {
        super.onCompleted();

        if (callback != null) {
          callback.onSuccess(resultObj);
        }
      }
    });
  }

  public static void countContent(CountContentForm form, final CountContentCallback callback) {
    instance().countContentInteractor.setCountIdeasForm(form);
    instance().countContentInteractor.execute(new BaseApiSubscriber<CountContentApiResult>(callback) {
      @Override
      public void onCompleted() {
        super.onCompleted();

        if (callback != null) {
          callback.onSuccess(resultObj.getContentCount());
        }
      }
    });
  }

  public static void giveFeedback(GiveFeedbackForm form, final GiveFeedbackCallback callback) {
    instance().contentFeedbackInteractor.setContentFeedbackForm(form);
    instance().contentFeedbackInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void likeContent(LikeContentForm form, final LikeContentCallback callback) {
    instance().likeContentInteractor.setContentOpinionForm(form);
    instance().likeContentInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void dislikeContent(DislikeContentForm form, final DislikeContentCallback callback) {
    instance().dislikeContentInteractor.setContentOpinionForm(form);
    instance().dislikeContentInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class RetrieveContentForm extends GetContentsForm {

  }

  public static class CountContentForm extends com.playbasis.pbcore.rest.form.content.CountContentForm {

  }

  public static class GiveFeedbackForm extends ContentFeedbackForm {

    public GiveFeedbackForm(String contentId, String playerId) {
      super(contentId, playerId);
    }
  }

  public static class LikeContentForm extends com.playbasis.pbcore.rest.form.content.LikeContentForm {

    public LikeContentForm(String contentId, String playerId) {
      super(contentId, playerId);
    }
  }

  public static class DislikeContentForm extends com.playbasis.pbcore.rest.form.content.DislikeContentForm {

    public DislikeContentForm(String contentId, String playerId) {
      super(contentId, playerId);
    }
  }

  public interface RetrieveContentCallback extends BasicApiCallbackWithResult<List<Content>> {

  }

  public interface CountContentCallback extends BaseApiCallback {
    void onSuccess(Integer count);
  }

  public interface GiveFeedbackCallback extends BasicApiCallback {

  }

  public interface LikeContentCallback extends BasicApiCallback {

  }

  public interface DislikeContentCallback extends BasicApiCallback {

  }
}
