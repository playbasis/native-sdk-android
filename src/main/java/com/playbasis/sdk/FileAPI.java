package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerFileAPIComponent;
import com.playbasis.pbcore.dependency.module.FileModule;
import com.playbasis.pbcore.domain.interactor.file.UploadImageInteractor;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class FileAPI {

  private static FileAPI fileAPI;

  @Inject
  protected UploadImageInteractor uploadImageInteractor;

  public static FileAPI instance() {
    if (fileAPI == null) {
      fileAPI = new FileAPI();

      DaggerFileAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .fileModule(new FileModule())
          .build()
          .inject(fileAPI);
    }

    return fileAPI;
  }
}
