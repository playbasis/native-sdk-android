package com.playbasis.pbcore.rest;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.gson.Gson;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.model.Birthdate;
import com.playbasis.pbcore.helper.GsonHelper;
import com.playbasis.pbcore.rest.adapter.CodesAdapter;
import com.playbasis.pbcore.rest.adapter.EventAdapter;
import com.playbasis.pbcore.rest.adapter.GsonBirthdateAdapter;
import com.playbasis.pbcore.rest.adapter.PlayerCustomFieldAdapter;
import com.playbasis.pbcore.rest.adapter.PlayerRankAdapter;
import com.playbasis.pbcore.rest.adapter.QuestLeaderboardCurrentPlayerAdapter;
import com.playbasis.pbcore.rest.adapter.RecentActivityDataAdapter;
import com.playbasis.pbcore.rest.adapter.RewardDataAdapter;
import com.playbasis.pbcore.rest.response.EventResponse;
import com.playbasis.pbcore.rest.response.GoodsResponse;
import com.playbasis.pbcore.rest.response.PlayerRankResponse;
import com.playbasis.pbcore.rest.response.RecentActivityResponse;
import com.playbasis.pbcore.rest.response.RewardResponse;
import com.playbasis.pbcore.rest.result.player.GetUserCustomFieldsApiResult;
import com.playbasis.pbcore.rest.result.quest.QuestLeaderboardApiResult;
import com.playbasis.pbcore.rest.service.CommunicationService;
import com.playbasis.pbcore.rest.service.ContentService;
import com.playbasis.pbcore.rest.service.EngineService;
import com.playbasis.pbcore.rest.service.GoodsService;
import com.playbasis.pbcore.rest.service.ImageService;
import com.playbasis.pbcore.rest.service.LinkService;
import com.playbasis.pbcore.rest.service.MerchantService;
import com.playbasis.pbcore.rest.service.PlayerService;
import com.playbasis.pbcore.rest.service.QuestService;
import com.playbasis.pbcore.rest.service.RedeemService;
import com.playbasis.pbcore.rest.service.ServiceService;
import com.playbasis.pbcore.rest.service.StoreOrganizeService;
import com.playbasis.pbcore.rest.service.TokenService;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by gregoire barret on 11/12/15.
 * For Stroll Guam project.
 */
public class RestClient {

  public static final String TAG = "RestClient";

  protected Context context;
  protected Retrofit retrofit;

  protected TokenService tokenService;
  protected PlayerService playerService;
  protected EngineService engineService;
  protected ImageService imageService;
  protected ContentService contentService;
  protected CommunicationService communicationService;
  protected StoreOrganizeService storeOrganizeService;
  protected GoodsService goodsService;
  protected MerchantService merchantService;
  protected QuestService questService;
  protected RedeemService redeemService;
  protected ServiceService serviceService;
  protected LinkService linkService;

  protected String apiKey;
  protected String apiSecret;

  @Inject
  public RestClient(Context context, PBThreadExecutor threadExecutor) {
    this.context = context;

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    retrofit = new Retrofit.Builder()
        .baseUrl(getBaseUrl())
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(getGson()))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.from(threadExecutor)))
        .build();

    tokenService = retrofit.create(TokenService.class);
    playerService = retrofit.create(PlayerService.class);
    engineService = retrofit.create(EngineService.class);
    imageService = retrofit.create(ImageService.class);
    contentService = retrofit.create(ContentService.class);
    communicationService = retrofit.create(CommunicationService.class);
    storeOrganizeService = retrofit.create(StoreOrganizeService.class);
    goodsService = retrofit.create(GoodsService.class);
    merchantService = retrofit.create(MerchantService.class);
    questService = retrofit.create(QuestService.class);
    redeemService = retrofit.create(RedeemService.class);
    serviceService = retrofit.create(ServiceService.class);
    linkService = retrofit.create(LinkService.class);
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
        .registerTypeAdapter(GoodsResponse.CodeResponse.class, new CodesAdapter())
        .registerTypeAdapter(GetUserCustomFieldsApiResult.PlayerCustomFieldResponse.class, new PlayerCustomFieldAdapter())
        .registerTypeAdapter(PlayerRankResponse.class, new PlayerRankAdapter())
        .registerTypeAdapter(QuestLeaderboardApiResult.Response.class, new QuestLeaderboardCurrentPlayerAdapter())
        .registerTypeAdapter(EventResponse.class, new EventAdapter())
        .registerTypeAdapter(RecentActivityResponse.class, new RecentActivityDataAdapter())
        .registerTypeAdapter(RewardResponse.RewardDataInterface.class, new RewardDataAdapter())
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
   * Getter for the PlayerResponse service.
   *
   * @return PlayerResponse service
   */
  public PlayerService getPlayerService() {
    return playerService;
  }

  public EngineService getEngineService() {
    return engineService;
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

  public CommunicationService getCommunicationService() {
    return communicationService;
  }

  /**
   * Getter for the content service.
   *
   * @return store org service
   */
  public StoreOrganizeService getStoreOrganizeService() {
    return storeOrganizeService;
  }

  public GoodsService getGoodsService() {
    return goodsService;
  }

  public MerchantService getMerchantService() {
    return merchantService;
  }

  public QuestService getQuestService() {
    return questService;
  }

  public RedeemService getRedeemService() {
    return redeemService;
  }

  public ServiceService getServiceService() {
    return serviceService;
  }

  public LinkService getLinkService() {
    return linkService;
  }

  public String getBaseUrl() {
    return "https://api.pbapp.net/";
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getApiKey() {
    if (apiKey != null) {
      return apiKey;
    }

    Bundle metadata = getMetadata();

    if (metadata == null) {
      return null;
    }

    apiKey = metadata.getString("playbasis_api_key");

    if (apiKey == null) {
      apiKey = String.valueOf(metadata.getInt("playbasis_api_key"));
    }

    return apiKey;
  }

  public void setApiSecret(String apiSecret) {
    this.apiSecret = apiSecret;
  }

  public String getApiSecret() {
    if (apiSecret != null) {
      return apiSecret;
    }

    Bundle metadata = getMetadata();

    if (metadata == null) {
      return null;
    }

    apiSecret = metadata.getString("playbasis_api_secret");
    return apiSecret;
  }

  private Bundle getMetadata() {
    ApplicationInfo ai = null;

    try {
      ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
    } catch (PackageManager.NameNotFoundException e) {
      e.printStackTrace();
    }

    return ai.metaData;
  }
}
