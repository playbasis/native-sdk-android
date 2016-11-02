package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerGenericAPIComponent;
import com.playbasis.pbcore.dependency.module.GenericModule;
import com.playbasis.pbcore.domain.interactor.generic.GenericGetInteractor;
import com.playbasis.pbcore.domain.interactor.generic.GenericPostInteractor;
import com.playbasis.pbcore.rest.form.generic.GenericForm;
import com.playbasis.pbcore.rest.result.generic.GenericApiResult;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class GenericAPI {

  private static GenericAPI genericAPI;

  @Inject
  protected GenericGetInteractor genericGetInteractor;
  @Inject
  protected GenericPostInteractor genericPostInteractor;

  public static GenericAPI instance() {
    if (genericAPI == null) {
      genericAPI = new GenericAPI();

      DaggerGenericAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .genericModule(new GenericModule())
          .build()
          .inject(genericAPI);
    }

    return genericAPI;
  }

  public static void get(GetForm form, GetCallback callback) {
    instance().genericGetInteractor.setGenericForm(form);
    instance().genericGetInteractor.execute(new BaseApiSubscriber(callback));
  }

  public static void post(PostForm form, PostCallback callback) {
    instance().genericPostInteractor.setGenericForm(form);
    instance().genericPostInteractor.execute(new BaseApiSubscriber(callback));
  }

  public static class GetForm extends GenericForm {
    public GetForm(String url) {
      super(url);
    }
  }

  public static class PostForm extends GenericForm {
    public PostForm(String url) {
      super(url);
    }
  }

  public interface GetCallback extends BasicApiCallbackWithResult<GenericApiResult> {

  }

  public interface PostCallback extends BasicApiCallbackWithResult<GenericApiResult> {

  }
}
