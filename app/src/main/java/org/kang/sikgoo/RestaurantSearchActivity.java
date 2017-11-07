package org.kang.sikgoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantSearchActivity extends AppCompatActivity {
    RestaurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_search);

        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new RestaurantAdapter();
        adapter.addItem(new RestaurantInfo(0,"test","heelo",new String[]{"he","sh"}));

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                RestaurantInfo item = (RestaurantInfo) adapter.getItem(i);

            }
        });
    }

    class RestaurantAdapter extends BaseAdapter{
        ArrayList<RestaurantInfo> items = new ArrayList<RestaurantInfo>();
        public void addItem(RestaurantInfo item) {items.add(item);}

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            RestaurantInfoView view = null;
            if(convertView == null) {
                view = new RestaurantInfoView(getApplicationContext());
            } else {
                view = (RestaurantInfoView) convertView;
            }

            RestaurantInfo item = items.get(i);
            item.setName(item.getName());
            item.setHash(item.getHash());
            item.setId(item.getId());

            return view;
        }
    }
}
