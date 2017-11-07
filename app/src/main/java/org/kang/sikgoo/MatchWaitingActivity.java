package org.kang.sikgoo;

        import android.app.NotificationManager;
        import android.content.Context;
        import android.content.Intent;
        import android.nfc.Tag;
        import android.support.v4.app.NotificationCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import com.google.gson.Gson;

        import java.util.List;


public class MatchWaitingActivity extends AppCompatActivity {
    TextView textView;
    Button testButton;

    MatcherTask matcherTask;
    Matcher result;
    NotificationManager mNotifyManager;
    NotificationCompat.Builder mBuilder;
    String id = "test";

    Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchwaiting);
        textView = findViewById(R.id.test);
        testButton = findViewById(R.id.testButton);

        matcherTask = new MatcherTask(id);
        makeNotify();

        showNotify();
        matcherTask.execute(true);
        try {
            result = matcherTask.get();
            textView.setText(result.toString());
        }catch(Exception e){
            Log.d("Matcher","Failed");
        }

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelNotify();
                Intent intent = new Intent(getApplicationContext(), FirebaseChatActivity.class);
                startActivity(intent);
            }
        });

    }
    private void makeNotify(){
        mNotifyManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("매칭 중")
                .setContentText("오늘의 혼밥러는?")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setProgress(0,0,true)
                .setOngoing(true); // 사라지지 않게 한다
    }
    private void showNotify(){
        mNotifyManager.notify(0, mBuilder.build());
    }
    private void cancelNotify(){
        mNotifyManager.cancel(0);
    }

}
