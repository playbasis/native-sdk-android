package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.GoodsModule;
import com.playbasis.sdk.GoodsAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { GoodsModule.class })
public interface GoodsAPIComponent {

  void inject(GoodsAPI goodsAPI);

}
