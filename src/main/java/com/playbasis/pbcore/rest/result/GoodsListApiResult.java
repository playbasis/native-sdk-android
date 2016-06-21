package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.response.GoodsResponse;

import java.util.List;

/**
 * Created by Tar on 6/21/16 AD.
 */
public class GoodsListApiResult extends PBApiResult<GoodsListApiResult.Response> {

  public List<GoodsResponse> getGoodsResponses() {
    return response.goodsResponses;
  }

  public class Response {

    @SerializedName("goods_list")
    List<GoodsResponse> goodsResponses;

  }
}
