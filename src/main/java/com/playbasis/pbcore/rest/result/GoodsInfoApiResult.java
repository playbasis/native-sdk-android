package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.response.GoodsResponse;

/**
 * Created by Tar on 6/21/16 AD.
 */
public class GoodsInfoApiResult extends PBApiResult<GoodsInfoApiResult.Response> {

  public GoodsResponse getGoodsResponse() {
    response.goodsResponse.amount = response.amount;
    return response.goodsResponse;
  }

  public class Response {

    @SerializedName("goods")
    GoodsResponse goodsResponse;
    @SerializedName("amount")
    int amount;

  }
}
