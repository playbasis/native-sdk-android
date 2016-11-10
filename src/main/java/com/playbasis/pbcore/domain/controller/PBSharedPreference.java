package com.playbasis.pbcore.domain.controller;

import android.content.Context;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.playbasis.pbcore.domain.model.Organization;
import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.Token;
import com.playbasis.pbcore.helper.MD5;
import com.playbasis.pbcore.helper.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tar on 4/20/16 AD.
 */
public class PBSharedPreference {

  public static final String TAG = "SharedPreference";
  public static final String USER = "User";

  protected Context mContext;

  @Inject
  public PBSharedPreference(Context context) {
    mContext = context;
  }

  public String tokenSaveKey() {
    return MD5.encrypt(mContext.getPackageName() + "TOKEN");
  }

  public String apiKeySaveKey() {
    return MD5.encrypt(mContext.getPackageName() + "API_KEY");
  }

  public String apiSecretSaveKey() {
    return MD5.encrypt(mContext.getPackageName() + "API_SECRET");
  }

  public Token readToken() {
    String tokenData = SharedPreferenceHelper.getPreferenceString(mContext, tokenSaveKey(), null);

    if (tokenData == null) {
      return null;
    } else {
      try {
        return new Gson().fromJson(tokenData, Token.class);
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }
  }

  public void writeToken(Token token) {
    String tokenData = null;

    if (token != null) {
      tokenData = new Gson().toJson(token);
    }

    SharedPreferenceHelper.setPreference(mContext, tokenSaveKey(), tokenData);
  }

  public String readApiKey() {
    return SharedPreferenceHelper.getPreferenceString(mContext, apiKeySaveKey(), null);
  }

  public void writeApiKey(String apiKey) {
    SharedPreferenceHelper.setPreference(mContext, apiKeySaveKey(), apiKey);
  }

  public String readApiSecret() {
    return SharedPreferenceHelper.getPreferenceString(mContext, apiSecretSaveKey(), null);
  }

  public void writeApiSecret(String apiSecret) {
    SharedPreferenceHelper.setPreference(mContext, apiSecretSaveKey(), apiSecret);
  }

  @Nullable
  public <T extends Player> T readPlayer(Class<T> klass) {
    Gson gson = new Gson();
    String json = SharedPreferenceHelper.getPreferenceString(mContext, USER, null);
    if (json != null) {
      try {
        return gson.fromJson(json, klass);
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    } else {
      return null;
    }
  }

  public void writePlayer(@Nullable Player userModel) {
    Gson gson = new Gson();
    String jsonUser = userModel == null ? null : gson.toJson(userModel);
    SharedPreferenceHelper.setPreference(mContext, USER, jsonUser);
  }

  public <T extends Organization> List<T> readOrganizations(Class<T> klass, String key) {
    try {
      Gson gson = new Gson();
      String json = SharedPreferenceHelper.getPreferenceString(mContext, key, null);
      JsonParser parser = new JsonParser();
      JsonArray jsonArray = parser.parse(json).getAsJsonArray();
      List<T> results = new ArrayList<>();

      for (JsonElement element : jsonArray) {
        T t = gson.fromJson(element, klass);
        results.add(t);
      }

      return results;
    } catch (Exception e) {
      return null;
    }
  }

  public <T extends Organization> void writeOrganizations(List<T> organizations, String key) {
    Gson gson = new Gson();
    String json = organizations == null ? null : gson.toJson(organizations);
    SharedPreferenceHelper.setPreference(mContext, key, json);
  }
}
