package com.gads.leaderboard;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("/posts")
    @FormUrlEncoded
//    Call<Submission> savePost(@Body Submission post);
    Call<Submission> savePost(@Field("entry.1877115667") String firstName,
                              @Field("entry.2006916086") String secondName,
                              @Field("entry.1824927963") String email,
                              @Field("entry.284483984")String git);

}
