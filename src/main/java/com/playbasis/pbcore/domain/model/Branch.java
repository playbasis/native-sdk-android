package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.BranchResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 8/31/16 AD.
 */
public class Branch extends PBModel {

  protected String branchId;
  protected String name;

  public Branch() {

  }

  public Branch(BranchResponse response) {
    update(response);
  }

  public static ArrayList<Branch> createBranchs(List<BranchResponse> responses) {
    ArrayList<Branch> branches = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return branches;
    }

    for (BranchResponse branchResponse : responses) {
      branches.add(new Branch(branchResponse));
    }

    return branches;
  }

  public void update(BranchResponse response) {
    this.branchId = response.branchId;
    this.name = response.banchName;
  }

  public String getBranchId() {
    return branchId;
  }

  public String getName() {
    return name;
  }
}
