package com.example.app.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tabLayout;

    RelativeLayout content;
    View slider;
    AnimatorSet anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slider = findViewById(R.id.slider);

        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
//
//        tabLayout = (TabLayout) findViewById(R.id.tabs);
//
//
//        View ll = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
//                .inflate(R.layout.custom_tab, null, false);
//
//        double value = 34.534232;
//        BigDecimal bd = new BigDecimal(value);
//        bd.setScale(1, RoundingMode.HALF_UP);
//        bd.doubleValue();
//
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
//        tabLayout.a
//        tabLayout.getTabAt(0).setCustomView(ll);
//        tabLayout.getTabAt(1).setCustomView(ll);
//        tabLayout.getTabAt(2).setCustomView(ll);
    }

    @Override
    public void onClick(View v) {
        slider.setVisibility(View.VISIBLE);

        if(anim!=null && anim.isRunning()){
            anim.cancel();
        }

        ObjectAnimator x = ObjectAnimator.ofFloat(slider,
                "translationX", v.getX());

        ValueAnimator y = ValueAnimator.ofInt(slider.getMeasuredWidth(), v.getMeasuredWidth());

        y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = slider.getLayoutParams();
                layoutParams.width = val;
                slider.setLayoutParams(layoutParams);
            }
        });

        anim = new AnimatorSet();
        anim.playTogether(x, y);
        anim.start();
        anim.setDuration(100);

    }
}
