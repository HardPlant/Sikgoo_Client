package org.kang.sikgoo;

import android.os.AsyncTask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KANG on 2017-10-17.
 */

public class RestaurantInfoTask extends AsyncTask {
    public static final String TAG = "RestaurantInfoTask";

    Retrofit client;
    RestaurantInfo.RESTRequest service;
    RestaurantInfo restaurantInfo;

    @Override
    protected void onPreExecute() {
        client = new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service =
                client.create(RestaurantInfo.RESTRequest.class);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }
}
