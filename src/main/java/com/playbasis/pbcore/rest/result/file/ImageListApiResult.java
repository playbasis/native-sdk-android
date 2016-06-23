package com.playbasis.pbcore.rest.result.file;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class ImageListApiResult extends PBApiResult<List<ImageListApiResult.Response>> {

  public class Response {
    @SerializedName("file_name")
    public String fileName;
    @SerializedName("date_added")
    public Date dateAdded;
    @SerializedName("date_modified")
    public Date dateModified;
  }
}
