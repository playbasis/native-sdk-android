package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.CommunicationModule;
import com.playbasis.sdk.CommunicationAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = {CommunicationModule.class})
public interface CommunicationAPIComponent {

  void inject(CommunicationAPI communicationAPI);

}
