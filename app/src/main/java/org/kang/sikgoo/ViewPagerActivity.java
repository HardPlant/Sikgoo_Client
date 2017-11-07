package org.kang.sikgoo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import org.kang.sikgoo.fragment.MainFragment;
import org.kang.sikgoo.fragment.RestaurantFragment;

public class ViewPagerActivity extends AppCompatActivity {

    private MaterialViewPager mViewPager;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        setTitle("식구");

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        final Toolbar toolbar = mViewPager.getToolbar();
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        mViewPager.setMaterialViewPagerListener(new MaterialViewPagerListener());

        ViewPager viewPager = mViewPager.getViewPager();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(viewPagerAdapter.getCount());


        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter{
        private final String[] titles = {"메인","이벤트","뭐 먹지?", "초대하기"};
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
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
            return 4;
        }
    }
    private class MaterialViewPagerListener implements MaterialViewPager.Listener{
        @Override
        public HeaderDesign getHeaderDesign(int page) {
            switch(page){
                case 0:
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.green,
                            "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");
                case 1:
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.blue,
                            "http://www.hdiphonewallpapers.us/phone-wallpapers/540x960-1/540x960-mobile-wallpapers-hd-2218x5ox3.jpg");
                case 2:
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.cyan,
                            "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                case 3:
                    return HeaderDesign.fromColorResAndUrl(
                            R.color.red,
                            "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
            }
            return null;
        }
    }
}
