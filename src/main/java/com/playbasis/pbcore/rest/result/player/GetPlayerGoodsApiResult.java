package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.response.GoodsResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.List;

/**
 * Created by Tar on 6/20/16 AD.
 */
public class GetPlayerGoodsApiResult extends PBApiResult<GetPlayerGoodsApiResult.Response> {

  public List<GoodsResponse> getGoodsResponse() {
    return response.goodsResponse;
  }

  public class Response {

    @SerializedName("goods")
    List<GoodsResponse> goodsResponse;
  }

}
