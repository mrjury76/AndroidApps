package com.example.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the tabLayout and viewPager2
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        //making the tabs
        TabLayout.Tab sportsTab = tabLayout.newTab();
        sportsTab.setText("Sports");
        tabLayout.addTab(sportsTab);

        TabLayout.Tab topStoriesTab = tabLayout.newTab();
        topStoriesTab.setText("Top Stories");
        tabLayout.addTab(topStoriesTab);

        TabLayout.Tab techTab = tabLayout.newTab();
        techTab.setText("Technology");
        tabLayout.addTab(techTab);

        //initializing the adapter to the view pager
        NewsPagerAdapter adapter = new NewsPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        //makes the current view tha fragment that is selected
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        //changes the tab index when scrolling to a different fragment
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                // This method is called when a page is scrolled
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Select the corresponding tab when a page is selected
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                // This method is called when the page scroll state changes
            }
        });
    }
}