package org.kang.sikgoo.data;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by KANG on 2017-09-20.
 */

public class RestaurantInfo {
    int id;
    String name;
    String genre;
    String[] hash;

    public RestaurantInfo(int id, String name, String genre, String[] hash) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.hash = hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String[] getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "RestaurantInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", hash=" + Arrays.toString(hash) +
                '}';
    }

    public void setHash(String[] hash) {
        this.hash = hash;
    }

    public interface RESTRequest{
        @GET("/restaurant_all")
        Call<RestaurantInfo> getAllRestaurant();

        @GET("/restaurant")
        Call<RestaurantInfo> findRestaurantByGenre(@Query("genre")String Genre);

        @GET("/restaurant")
        Call<RestaurantInfo> findRestaurantByName(@Query("name")String Genre);
    }
}
