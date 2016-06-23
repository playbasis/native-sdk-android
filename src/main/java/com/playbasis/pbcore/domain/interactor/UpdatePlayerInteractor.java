package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.UpdatePlayerForm;
import com.playbasis.pbcore.rest.form.UploadImageForm;
import com.playbasis.pbcore.rest.result.UpdatePlayerDetailApiResult;
import com.playbasis.pbcore.rest.result.UploadImageApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UpdatePlayerInteractor extends PlayBasisApiInteractor {

  private UpdatePlayerForm form;
  private UploadImageInteractor uploadImageInteractor;

  @Inject
  public UpdatePlayerInteractor(ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor,
                                UploadImageInteractor uploadImageInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

    this.uploadImageInteractor = uploadImageInteractor;
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    if (form.getProfilePictureFile() != null) {
      UploadImageForm uploadImageForm = new UploadImageForm(form.getPlayerId(), form.getProfilePictureFile());
      uploadImageInteractor.setUploadImageForm(uploadImageForm);

      return uploadImageInteractor.buildUseCaseObservable().map(new Func1<UploadImageApiResult, UploadImageApiResult>() {
        @Override
        public UploadImageApiResult call(UploadImageApiResult uploadImageApiResult) {
          if (uploadImageApiResult.success) {
            form.setImageUrl(uploadImageApiResult.response.url);
          }

          return uploadImageApiResult;
        }
      }).flatMap(new Func1<UploadImageApiResult, Observable<UpdatePlayerDetailApiResult>>() {
        @Override
        public Observable<UpdatePlayerDetailApiResult> call(UploadImageApiResult uploadImageApiResult) {
          return buildUpdateUserObservable();
        }
      });
    } else {
      return buildUpdateUserObservable();
    }
  }

  private Observable<UpdatePlayerDetailApiResult> buildUpdateUserObservable() {
    return restClient.getPlayerService().updatePlayer(
        form.getPlayerId(),
        getApiToken(),
        form.getFirstName(),
        form.getLastName(),
        form.getGenderValue(),
        form.getBirthdateValue(),
        form.getImageUrl()
    ).map(new PBApiErrorCheckFunc<UpdatePlayerDetailApiResult>());
  }

  public void setUpdateUserForm(UpdatePlayerForm updatePlayerForm) {
    this.form = updatePlayerForm;
  }
}
