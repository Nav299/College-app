package com.example.kgrcet;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    int tabcount;

    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new NewsFragment();
            case 1:
                return new HomeFragment();
            case 2:
                return new SelectedFragment();
            case 3:
                return new StaffFragment();
            case 4:
                return new AboutFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }


}
