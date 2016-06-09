package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.DeleteImageApiResult;
import com.playbasis.pbcore.rest.result.ImageListApiResult;
import com.playbasis.pbcore.rest.result.UploadImageApiResult;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Tar on 5/4/16 AD.
 */
public interface ImageService {

  @GET("File/list")
  Observable<ImageListApiResult> getImageList(
      @NonNull @Query("api_key") String apiKey,
      @Query("player_id") String playerId,
      @Query("sort") String sort,
      @Query("order") String order
  );

  @Multipart
  @POST("File/upload")
  Observable<UploadImageApiResult> uploadImage(
      @Part("token") RequestBody token,
      @Part("player_id") RequestBody playerId,
      @Part MultipartBody.Part image
  );

  @POST("File/delete")
  Observable<DeleteImageApiResult> deleteImage(
      @Field("token") String token,
      @Field("file_name") String fileName
  );
}
