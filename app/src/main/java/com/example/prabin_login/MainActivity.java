package com.example.prabin_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import com.example.prabin_login.adapters.ViewPagerAdapter;
import com.example.prabin_login.fragments.LoginFragment;
import com.example.prabin_login.fragments.SignupFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabID);

        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter((getSupportFragmentManager()));
        viewPagerAdapter.addFragment(new LoginFragment(),"LOGIN");
        viewPagerAdapter.addFragment(new SignupFragment(),"SIGNUP");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }



}
