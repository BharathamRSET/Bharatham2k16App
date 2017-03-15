package josephvarghese.roundmelon.dell.bharathamone;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class DayOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_one);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Chavara Hall"));
        tabLayout.addTab(tabLayout.newTab().setText("Gallery Hall"));
        tabLayout.addTab(tabLayout.newTab().setText("Pareeksha Bhavan H1"));
        tabLayout.addTab(tabLayout.newTab().setText("Pareeksha Bhavan H2"));
        tabLayout.addTab(tabLayout.newTab().setText("Pareeksha Bhavan H3"));
        tabLayout.addTab(tabLayout.newTab().setText("Pareeksha Bhavan H4"));
        tabLayout.addTab(tabLayout.newTab().setText("Pareeksha Bhavan H5"));
        tabLayout.addTab(tabLayout.newTab().setText("Lecture Hall"));
        tabLayout.addTab(tabLayout.newTab().setText("Lecture Hall"));


        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);




        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter1 adapter = new PagerAdapter1(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





    }
}
