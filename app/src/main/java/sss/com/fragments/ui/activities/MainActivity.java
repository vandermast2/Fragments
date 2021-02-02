package sss.com.fragments.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

import sss.com.fragments.ui.fragments.friday.FridayFragment;
import sss.com.fragments.ui.fragments.monday.MondayFragment;
import sss.com.fragments.ui.adapters.MyViewPagerAdapter;
import sss.com.fragments.R;
import sss.com.fragments.ui.fragments.saturday.SaturdayFragment;
import sss.com.fragments.ui.fragments.sunday.SundayFragment;
import sss.com.fragments.ui.fragments.thursday.ThursdayFragment;
import sss.com.fragments.ui.fragments.tuesday.TuesdayFragment;
import sss.com.fragments.ui.fragments.wednesday.WednesdayFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyViewPagerAdapter adapter;

    private boolean isActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "ON_CREATE");
        viewPager = findViewById(R.id.containerLay);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new MyViewPagerAdapter(getSupportFragmentManager(),
                Arrays.asList(
                        new SundayFragment(),
                        new MondayFragment(),
                        new TuesdayFragment(),
                        new WednesdayFragment(),
                        new ThursdayFragment(),
                        new FridayFragment(),
                        new SaturdayFragment()));

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void addFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(viewPager.getId(), new MondayFragment(),"Monday");
    }


}