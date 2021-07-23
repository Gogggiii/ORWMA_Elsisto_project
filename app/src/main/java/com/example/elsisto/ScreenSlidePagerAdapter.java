package com.example.elsisto;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 4;

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Resistor_4_Rings.newInstance();
            case 1:
                return Resistor_5_Rings.newInstance();
            case 2:
                return KondenzatorA.newInstance();
            default:
                return KondenzatorB.newInstance();
        }
    }

    public CharSequence getPageTitle(int position){
        switch(position) {
            case 0:
                return "Otpornik\n4 prstena";
            case 1:
                return "Otpornik\n5 prstena";
            case 2:
                return "Kondenzator\nA";
            default:
                return "Kondenzator\nB";
        }
    }
    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
