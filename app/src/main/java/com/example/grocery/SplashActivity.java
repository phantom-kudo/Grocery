package com.example.grocery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import org.jetbrains.annotations.NotNull;

public class SplashActivity extends AppCompatActivity {
    TextView splashtxt,skip;
    ImageView splashbg,logo;
    LottieAnimationView lottieAnimationView;

    private static final int NUM_PAGES = 3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;
    Animation anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                ,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        splashbg = findViewById(R.id.splashbg);
        splashtxt = findViewById(R.id.splashtxt);
        logo = findViewById(R.id.logo);
        lottieAnimationView = findViewById(R.id.lottieAnimationView);
        skip = findViewById(R.id.skip);

        viewPager = findViewById(R.id.liquidpager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        anim = AnimationUtils.loadAnimation(this,R.anim.liquidanim);
        viewPager.startAnimation(anim);

        splashbg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        splashtxt.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);




    }




    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(@NonNull @NotNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @NotNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    OnBoardingFragment1 tab1 = new OnBoardingFragment1();
                    return tab1;
                case 1:
                    OnBoardingFragment2 tab2 = new OnBoardingFragment2();
                    return tab2;
                case 2:
                    OnBoardingFragment3 tab3 = new OnBoardingFragment3();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}