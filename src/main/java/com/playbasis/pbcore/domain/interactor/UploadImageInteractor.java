package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.UploadImageForm;
import com.playbasis.pbcore.rest.result.UploadImageApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UploadImageInteractor extends PlayBasisApiInteractor {

  private UploadImageForm form;

  @Inject
  public UploadImageInteractor(ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread,
                               RestClient restClient,
                               RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getImageService().uploadImage(
        RequestBody.create(MediaType.parse("text/plain"), getApiToken()),
        RequestBody.create(MediaType.parse("text/plain"), form.getPlayerId()),
        MultipartBody.Part.createFormData(
            "file",
            form.getFile().getName(),
            RequestBody.create(MediaType.parse("image/*"), form.getFile())
        )
    ).map(new PBApiErrorCheckFunc<UploadImageApiResult>());
  }

  public void setUploadImageForm(UploadImageForm uploadImageForm) {
    this.form = uploadImageForm;
  }
}
