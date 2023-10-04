package com.example.droidcafe;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    public PagerAdapter(@NotNull FragmentManager fragmentManager, @NotNull Lifecycle lifecycle){
        super(fragmentManager, lifecycle);
    }
    @NotNull
    @Override
    public Fragment createFragment(int position){
        return fragmentList.get(position);
    }
    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }
    @Override
    public int getItemCount(){
        return fragmentList.size();
    }
}
