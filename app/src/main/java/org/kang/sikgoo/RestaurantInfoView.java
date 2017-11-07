package org.kang.sikgoo;

import android.content.Context;
import android.media.Image;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kang.sikgoo.R;

/**
 * Created by KANG on 2017-09-20.
 */

public class RestaurantInfoView extends LinearLayout {
    TextView textName;
    TextView textHash;
    ImageView imageView;

    public RestaurantInfoView(Context context) {
        super(context);
        init(context);
    }

    public RestaurantInfoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.restaurant_item, this, true);

        textName = (TextView) findViewById(R.id.textName);
        textHash = (TextView) findViewById(R.id.textHash);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
    public void setName(String name) {
        textName.setText(name);
    }
    public void setHash(String[] hash) {
        for(String tag : hash){
            textHash.setText(textHash.getText() + " " + tag);
        }
    }
    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }


}
