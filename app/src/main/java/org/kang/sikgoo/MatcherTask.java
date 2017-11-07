package org.kang.sikgoo;

import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.kang.sikgoo.BuildConfig.SERVER_URL;

/**
 * Created by KANG on 2017-10-16.
 */

public class MatcherTask extends AsyncTask<Boolean,Integer,Matcher> {
    static final String TAG = "MatcherTask";
    Retrofit client;
    Matcher.MatcherInterface service;
    Matcher matcher;
    String clientId;


    @Override
    protected void onPreExecute() {
        client = new Retrofit.Builder()
                .baseUrl(SERVER_URL).
                        addConverterFactory(GsonConverterFactory.create())
                .build();
        service =
                client.create(Matcher.MatcherInterface.class);

        clientId = FirebaseInstanceId.getInstance().getToken();
    }

    @Override
    protected Matcher doInBackground(Boolean... booleans) {
        boolean isPost = booleans[0];
        request();
        return matcher;
    }

    @Override
    protected void onPostExecute(Matcher result) {
        super.onPostExecute(result);
    }

    public MatcherTask(String clientId) {
        this.clientId = clientId;
    }

    private void request(){
        Call<Matcher> call = service.check_matcher(clientId);
        call.enqueue(new Callback<Matcher>(){
            @Override
            public void onResponse(Call<Matcher> call, Response<Matcher> response) {
                if(response.isSuccessful()){
                    matcher = response.body();
                }
            }

            @Override
            public void onFailure(Call<Matcher> call, Throwable t) {
                Log.e(TAG,"실패: " + t.getMessage());
                Log.e(TAG, "요청 메시지: " + call.request());
            }
        });
    }

}
