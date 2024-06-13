package com.example.kgrcet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Homepage extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mAlbum,mFavorite,mPremium,mAbout,mnews;

    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;

    androidx.appcompat.widget.Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.viewpager);
        mAlbum=findViewById(R.id.tab_home);
        mFavorite=findViewById(R.id.tab_selected);
        mPremium=findViewById(R.id.tab_staff);
        mAbout=findViewById(R.id.tab_About);
        mnews=findViewById(R.id.tab_news);

        mtoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        Drawable drawable= ContextCompat.getDrawable(getApplicationContext(),R.drawable.baseline_more_vert_24);
        mtoolbar.setOverflowIcon(drawable);


        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(myPagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 || tab.getPosition()==4){

                    myPagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;

    }
}