package com.playbasis.pbcore.rest;

import javax.inject.Inject;

/**
 * Created by Tar on 3/21/16 AD.
 */
public class RestClientConfiguration {

  String baseUrl;
  String apiKey;
  String apiSecret;

  @Inject
  public RestClientConfiguration(String baseUrl, String apiKey, String apiSecret) {
    this.baseUrl = baseUrl;
    this.apiKey = apiKey;
    this.apiSecret = apiSecret;
  }
}
