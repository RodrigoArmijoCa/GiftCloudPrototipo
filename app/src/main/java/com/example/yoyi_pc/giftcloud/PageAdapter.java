package com.example.yoyi_pc.giftcloud;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {

    public List<Fragment> listaDeFragmentos =  new ArrayList<>();

    public PageAdapter(FragmentManager sm)
    {
        super(sm);
    }

    @Override
    public Fragment getItem(int position) {
        return listaDeFragmentos.get(position);
    }

    @Override
    public int getCount() {
        return listaDeFragmentos.size();
    }

    public void addFragment(Fragment fragmento)
    {
        listaDeFragmentos.add(fragmento);
    }
}
