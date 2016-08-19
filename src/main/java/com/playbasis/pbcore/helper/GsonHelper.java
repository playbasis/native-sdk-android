package com.playbasis.pbcore.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.playbasis.pbcore.rest.adapter.GsonDateAdapter;

import java.util.Date;

/**
 * Created by androiddev01 on 3/10/2016 AD.
 */
public class GsonHelper {

  public static final String TAG = "GsonHelper";

  public GsonHelper() {

  }

  public static Gson newGson() {
    return newGson(new GsonDateAdapter());
  }

  public static Gson newGson(GsonDateAdapter adapter) {
    return newBuilder(adapter).create();
  }

  public static GsonBuilder newBuilder() {
    return newBuilder(new GsonDateAdapter());
  }

  public static GsonBuilder newBuilder(GsonDateAdapter adapter) {
    return new GsonBuilder().registerTypeAdapter(Date.class, adapter);
  }
}
