package com.example.riteshlocal.githubexample.Service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ritesh.local on 5/19/2016.
 */
public interface CallAPI {

    /*Show Events*/
    @FormUrlEncoded
    @POST("get_events")
    Call<ResponseBody> getEventList(
            @Field("token") String token,
            @Field("page") String page
    );
}
