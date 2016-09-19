package com.playbasis.pbcore.domain.model;

import android.os.Parcel;

import com.playbasis.pbcore.rest.response.BranchResponse;
import com.playbasis.pbcore.rest.response.MerchantResponse;
import com.playbasis.pbcore.rest.result.merchant.AvailableBranchForGoodsGroupApiResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 8/31/16 AD.
 */
public class Merchant extends PBModel {

  protected String merchantId;
  protected String name;
  protected ArrayList<Branch> branches;

  public Merchant() {

  }

  public Merchant(MerchantResponse response) {
    update(response);
  }

  public Merchant(AvailableBranchForGoodsGroupApiResult.Response response) {
    update(response.merchantResponse);

    branches = new ArrayList<>();
    branches.addAll(createBranches(response.branchResponses));
  }

  public static ArrayList<Merchant> createMerchants(List<AvailableBranchForGoodsGroupApiResult.Response> responses) {
    ArrayList<Merchant> merchants = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return merchants;
    }

    for (AvailableBranchForGoodsGroupApiResult.Response response : responses) {
      merchants.add(new Merchant(response));
    }

    return merchants;
  }

  public void update(MerchantResponse response) {
    this.merchantId = response.merchantId;
    this.name = response.merchantName;
  }

  public String getMerchantId() {
    return merchantId;
  }

  public String getName() {
    return name;
  }

  public ArrayList<Branch> getBranches() {
    return branches;
  }

  protected List<Branch> createBranches(List<BranchResponse> branchResponses) {
    return Branch.createBranchs(branchResponses);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.merchantId);
    dest.writeString(this.name);
    dest.writeTypedList(this.branches);
  }

  protected Merchant(Parcel in) {
    this.merchantId = in.readString();
    this.name = in.readString();
    this.branches = in.createTypedArrayList(Branch.CREATOR);
  }

  public static final Creator<Merchant> CREATOR = new Creator<Merchant>() {
    @Override
    public Merchant createFromParcel(Parcel source) {
      return new Merchant(source);
    }

    @Override
    public Merchant[] newArray(int size) {
      return new Merchant[size];
    }
  };
}
