package com.example.droidcafe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabActivity extends AppCompatActivity {
    public String[] tabs = {"Top News","Tech News", "Cooking"};
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar = findViewById(R.id.toolbar_);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.top_stories));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tech_news));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.cooking));

        final ViewPager2 viewPager2 = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), getLifecycle());
        adapter.addFragment(new TabFragment1());
        adapter.addFragment(new TabFragment2());
        adapter.addFragment(new TabFragment3());

        viewPager2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager2,(tab, position) -> tab.setText(tabs[position])).attach();
    }
}
