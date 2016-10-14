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
import com.playbasis.pbcore.rest.service.BadgeService;
import com.playbasis.pbcore.rest.service.CommunicationService;
import com.playbasis.pbcore.rest.service.ContentService;
import com.playbasis.pbcore.rest.service.EngineService;
import com.playbasis.pbcore.rest.service.GameService;
import com.playbasis.pbcore.rest.service.GoodsService;
import com.playbasis.pbcore.rest.service.FileService;
import com.playbasis.pbcore.rest.service.HealthService;
import com.playbasis.pbcore.rest.service.LinkService;
import com.playbasis.pbcore.rest.service.MerchantService;
import com.playbasis.pbcore.rest.service.PlayerService;
import com.playbasis.pbcore.rest.service.QuestService;
import com.playbasis.pbcore.rest.service.QuizService;
import com.playbasis.pbcore.rest.service.RedeemService;
import com.playbasis.pbcore.rest.service.ServiceService;
import com.playbasis.pbcore.rest.service.SettingService;
import com.playbasis.pbcore.rest.service.StoreOrganizeService;
import com.playbasis.pbcore.rest.service.TokenService;
import com.playbasis.pbcore.rest.service.TripService;

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
  protected SettingService settingService;
  protected PlayerService playerService;
  protected BadgeService badgeService;
  protected GoodsService goodsService;
  protected MerchantService merchantService;
  protected EngineService engineService;
  protected QuestService questService;
  protected QuizService quizService;
  protected RedeemService redeemService;
  protected CommunicationService communicationService;
  protected ServiceService serviceService;
  protected StoreOrganizeService storeOrganizeService;
  protected ContentService contentService;
  protected LinkService linkService;
  protected FileService fileService;
  protected HealthService healthService;
  protected TripService tripService;
  protected GameService gameService;

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
    settingService = retrofit.create(SettingService.class);
    playerService = retrofit.create(PlayerService.class);
    badgeService = retrofit.create(BadgeService.class);
    goodsService = retrofit.create(GoodsService.class);
    merchantService = retrofit.create(MerchantService.class);
    engineService = retrofit.create(EngineService.class);
    questService = retrofit.create(QuestService.class);
    quizService = retrofit.create(QuizService.class);
    redeemService = retrofit.create(RedeemService.class);
    communicationService = retrofit.create(CommunicationService.class);
    serviceService = retrofit.create(ServiceService.class);
    storeOrganizeService = retrofit.create(StoreOrganizeService.class);
    contentService = retrofit.create(ContentService.class);
    linkService = retrofit.create(LinkService.class);
    fileService = retrofit.create(FileService.class);
    healthService = retrofit.create(HealthService.class);
    tripService = retrofit.create(TripService.class);
    gameService = retrofit.create(GameService.class);
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

  public TokenService getTokenService() {
    return tokenService;
  }

  public SettingService getSettingService() {
    return settingService;
  }

  public PlayerService getPlayerService() {
    return playerService;
  }

  public BadgeService getBadgeService() {
    return badgeService;
  }

  public GoodsService getGoodsService() {
    return goodsService;
  }

  public MerchantService getMerchantService() {
    return merchantService;
  }

  public EngineService getEngineService() {
    return engineService;
  }

  public QuestService getQuestService() {
    return questService;
  }

  public QuizService getQuizService() {
    return quizService;
  }

  public RedeemService getRedeemService() {
    return redeemService;
  }

  public CommunicationService getCommunicationService() {
    return communicationService;
  }

  public ServiceService getServiceService() {
    return serviceService;
  }

  public StoreOrganizeService getStoreOrganizeService() {
    return storeOrganizeService;
  }

  public ContentService getContentService() {
    return contentService;
  }

  public LinkService getLinkService() {
    return linkService;
  }

  public FileService getFileService() {
    return fileService;
  }

  public HealthService getHealthService() {
    return healthService;
  }

  public TripService getTripService() {
    return tripService;
  }

  public GameService getGameService() {
    return gameService;
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
