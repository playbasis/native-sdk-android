package com.playbasis.pbcore.rest;

import com.google.gson.Gson;
import com.playbasis.pbcore.domain.controller.PBSharedPreference;
import com.playbasis.pbcore.domain.model.Birthdate;
import com.playbasis.pbcore.rest.adapter.GsonBirthdateAdapter;
import com.playbasis.pbcore.rest.adapter.GsonPlayerAdapter;
import com.playbasis.pbcore.rest.result.response.PlayerResponse;
import com.playbasis.pbcore.rest.service.ContentService;
import com.playbasis.pbcore.rest.service.ImageService;
import com.playbasis.pbcore.rest.service.PlayerService;
import com.playbasis.pbcore.rest.service.StoreOrganizeService;
import com.playbasis.pbcore.rest.service.TokenService;
import com.smartsoftasia.ssalibrary.bus.ApplicationBus;
import com.smartsoftasia.ssalibrary.helper.GsonHelper;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gregoire barret on 11/12/15.
 * For Stroll Guam project.
 */
public class RestClient {
  public static final String TAG = "RestClient";

  // private LanguageController mLanguageController;
  protected PBSharedPreference mSharedPreference;
  protected ApplicationBus mApplicationBus;
  protected RestClientConfiguration mRestClientConfiguration;
  protected Retrofit retrofit;

  protected TokenService tokenService;
  protected PlayerService playerService;
  protected ImageService imageService;
  protected ContentService contentService;
  protected StoreOrganizeService storeOrganizeService;

  @Inject
  public RestClient(PBSharedPreference sharedPreference, ApplicationBus applicationBus,
                    RestClientConfiguration restClientConfiguration) {
    mSharedPreference = sharedPreference;
    mApplicationBus = applicationBus;
    mRestClientConfiguration = restClientConfiguration;

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    retrofit = new Retrofit.Builder()
        .baseUrl(getBaseUrl())
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(getGson()))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();

    tokenService = retrofit.create(TokenService.class);
    playerService = retrofit.create(PlayerService.class);
    imageService = retrofit.create(ImageService.class);
    contentService = retrofit.create(ContentService.class);
    storeOrganizeService = retrofit.create(StoreOrganizeService.class);
  }

  public RestClient(String url) {
    retrofit = new Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(getGson()))
        .build();
  }

  public Gson getGson() {
    return GsonHelper.newBuilder()
        .registerTypeAdapter(Birthdate.class, new GsonBirthdateAdapter())
        .registerTypeAdapter(PlayerResponse.class, new GsonPlayerAdapter())
        .create();
  }

  /**
   * Getter for the token service
   *
   * @return token service
   */
  public TokenService getTokenService() {
    return tokenService;
  }

  /**
   * Getter for the getPlayerInfoResponse service.
   *
   * @return getPlayerInfoResponse service
   */
  public PlayerService getPlayerService() {
    return playerService;
  }

  public ImageService getImageService() {
    return imageService;
  }

  /**
   * Getter for the content service.
   *
   * @return content service
   */
  public ContentService getContentService() {
    return contentService;
  }

  /**
   * Getter for the content service.
   *
   * @return store org service
   */
  public StoreOrganizeService getStoreOrganizeService() {
    return storeOrganizeService;
  }

  public String getBaseUrl() {
    return mRestClientConfiguration.baseUrl;
  }

  public String getApiKey() {
    return mRestClientConfiguration.apiKey;
  }
}
