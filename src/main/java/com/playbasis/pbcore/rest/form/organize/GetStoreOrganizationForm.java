package com.playbasis.pbcore.rest.form.organize;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetStoreOrganizationForm extends PBForm {

  protected String id;
  protected String organizationId;
  protected String parentId;
  protected String search;
  protected String sort;
  protected String order = "asc";
  protected int offset = 0;
  protected int limit = 20;

  public GetStoreOrganizationForm() {

  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("id", id);
    map.put("organize_id", organizationId);
    map.put("parent_id", parentId);
    map.put("search", search);
    map.put("sort", sort);
    map.put("order", order);
    map.put("offset", offset);
    map.put("limit", limit);

    return map;
  }

  public String getId() {
    return id;
  }

  public String getOrganizationId() {
    return organizationId;
  }

  public String getParentId() {
    return parentId;
  }

  public String getSearch() {
    return search;
  }

  public String getSort() {
    return sort;
  }

  public String getOrder() {
    return order;
  }

  public int getOffset() {
    return offset;
  }

  public int getLimit() {
    return limit;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public void setSearch(String search) {
    this.search = search;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }
}
