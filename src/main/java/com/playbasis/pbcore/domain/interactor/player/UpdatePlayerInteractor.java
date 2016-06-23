package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.file.UploadImageInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.UpdatePlayerForm;
import com.playbasis.pbcore.rest.form.file.UploadImageForm;
import com.playbasis.pbcore.rest.result.player.UpdatePlayerDetailApiResult;
import com.playbasis.pbcore.rest.result.file.UploadImageApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
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
