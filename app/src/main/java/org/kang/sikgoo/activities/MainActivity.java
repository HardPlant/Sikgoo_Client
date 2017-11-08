package org.kang.sikgoo.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import org.kang.sikgoo.R;
import org.kang.sikgoo.fragment.MainFragment;
import org.kang.sikgoo.fragment.RestaurantFragment;

public class MainActivity extends AppCompatActivity {
    Button match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ViewPagerActivity.class);
        startActivity(intent);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        match = (Button) findViewById(R.id.match);
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MatchWaitingActivity.class);
                startActivity(intent);

            }
        });

        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        ViewPager mViewPager = (ViewPager) findViewById(R.id.activity_viewpager);
        mViewPager.setAdapter(mainViewPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
    }

    private class MainViewPagerAdapter extends FragmentPagerAdapter{
        final String[] titles = {"홈","식당","초대","이벤트"};
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        public MainViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0: default:
                    return MainFragment.newInstance();
                case 1:
                    return new Fragment();
                case 2:
                    return RestaurantFragment.newInstance();
                case 3:
                    return new Fragment();
            }
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }


}
