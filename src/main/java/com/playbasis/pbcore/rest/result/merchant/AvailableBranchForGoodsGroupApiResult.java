package com.playbasis.pbcore.rest.result.merchant;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.response.BranchResponse;
import com.playbasis.pbcore.rest.response.MerchantResponse;
import com.playbasis.pbcore.rest.result.BaseUpdateUserApiResult;

import java.util.List;

/**
 * Created by Tar on 4/28/16 AD.
 */
public class AvailableBranchForGoodsGroupApiResult extends BaseUpdateUserApiResult<List<AvailableBranchForGoodsGroupApiResult.Response>> {

  public class Response {

    @SerializedName("branch")
    public List<BranchResponse> branchResponses;
    @SerializedName("merchant")
    public MerchantResponse merchantResponse;
  }

}
