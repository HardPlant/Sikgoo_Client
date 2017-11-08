package org.kang.sikgoo.Match;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by KANG on 2017-10-08.
 */


public class Matcher {
    @SerializedName("id")
    String id;
    @SerializedName("result")
    String result;

    @Override
    public String toString() {
        return "Matcher{" +
                "id=" + id +
                ", result='" + result + '\'' +
                '}';
    }

    public interface MatcherInterface{
        @GET("/match_room")
        Call<Matcher> check_matcher(@Query("id")String id);

        @POST("/match_room")
        Call<Matcher> register_matcher(@Query("id")String id);
    }

}
