package com.playbasis.pbcore.domain.interactor.file;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.file.UploadImageForm;
import com.playbasis.pbcore.rest.result.file.UploadImageApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UploadImageInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "UploadImageInteractor";

  protected UploadImageForm uploadImageForm;

  @Inject
  public UploadImageInteractor(PBThreadExecutor threadExecutor,
                               PBPostExecutionThread postExecutionThread,
                               RestClient restClient,
                               RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getImageService().uploadImage(
        RequestBody.create(MediaType.parse("text/plain"), getApiToken()),
        RequestBody.create(MediaType.parse("text/plain"), uploadImageForm.getPlayerId()),
        MultipartBody.Part.createFormData(
            "file",
            uploadImageForm.getFile().getName(),
            RequestBody.create(MediaType.parse("image/*"), uploadImageForm.getFile())
        )
    ).map(new PBApiErrorCheckFunc<UploadImageApiResult>());
  }

  public void setUploadImageForm(UploadImageForm uploadImageForm) {
    this.uploadImageForm = uploadImageForm;
  }
}
