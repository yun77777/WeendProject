package com.example.myapplication;

import kr.co.bootpay.analytics.LoginData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface PgApiService {


    @Headers("content-type: application/json; charset=utf8")
    @POST("request/token.json")
    Call<ResponseBody> getAccessToken(@Body Token token);

    @Headers("content-type: application/json; charset=utf8")
    @POST("cancel")
    Call<ResponseBody> cancel(@Body Token token);


//    @Headers("Accept: application/json; Content-Type: application/json; charset=utf-8")
//    @POST("request/token.json")
//    Call<ResponseBody> getAccessToken(@Body String body);

//    @GET("/request/token.json")
//    Call<ResponseBody> getAccessToken(@Query("data") String data);

//    @GET("/user/logout")
//    Call<ResponseBody> getLogoutFunc(@Query("data") String data);

    @FormUrlEncoded
    @POST("/retrofit/post")
    Call<ResponseBody> postFunc(@Field("data") String data);

    @FormUrlEncoded
    @PUT("/retrofit/put/{id}")
    Call<ResponseBody> putFunc(@Path("id") String id, @Field("data") String data);

    @DELETE("/retrofit/delete/{id}")
    Call<ResponseBody> deleteFunc(@Path("id") String id);
}