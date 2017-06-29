package com.projet_times_up.zac.pager_boilerplate.Activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.projet_times_up.zac.pager_boilerplate.Adapter.PagerAdapter;
import com.projet_times_up.zac.pager_boilerplate.Fragment.FirstFragment;
import com.projet_times_up.zac.pager_boilerplate.Fragment.SecondFragment;
import com.projet_times_up.zac.pager_boilerplate.Fragment.ThirdFragment;
import com.projet_times_up.zac.pager_boilerplate.R;

import java.util.List;
import java.util.Vector;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private PagerAdapter mPagerAdapter;
    private List fragments = new Vector();
    private ViewPager pager;
    private LinearLayout menu, menuIndicator;
    private LinearLayout.LayoutParams params;
    private RelativeLayout menuSelected;
    private float percentSelection = 1.0f;
    private TextView tvOne, tvTwo, tvThird;
    private ImageView indOne, indTwo, indThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPagerAdapter = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        pager = (ViewPager) findViewById(R.id.pager);
        menu = (LinearLayout) findViewById(R.id.menu);
        menuSelected = (RelativeLayout) findViewById(R.id.menu_select);
        tvOne = (TextView) findViewById(R.id.tv_one);
        tvTwo = (TextView) findViewById(R.id.tv_two);
        tvThird = (TextView) findViewById(R.id.tv_third);
        menuIndicator = (LinearLayout) findViewById(R.id.menu_indicator);
        indOne = (ImageView) menuIndicator.findViewById(R.id.indicator_one);
        indTwo = (ImageView) menuIndicator.findViewById(R.id.indicator_second);
        indThree = (ImageView) menuIndicator.findViewById(R.id.indicator_third);

        tvOne.setOnClickListener(this);
        tvTwo.setOnClickListener(this);
        tvThird.setOnClickListener(this);
        params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
        menuSelected.setLayoutParams(params);

        this.createPager();
        this.initPagerListener();

    }

    private void createPager() {
        fragments.add(Fragment.instantiate(this, FirstFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, SecondFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, ThirdFragment.class.getName()));

        pager.setAdapter(mPagerAdapter);
    }

    private void initPagerListener() {
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                MainActivity.this.showMenuSelected(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
                MainActivity.this.showMenuIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void showMenuIndicator(int position) {
        switch (position){
            case 0:
                indOne.setBackgroundResource(R.mipmap.selected_indicator);
                indTwo.setBackgroundResource(R.mipmap.default_indicator);
                indThree.setBackgroundResource(R.mipmap.default_indicator);
                break;
            case 1:
                indOne.setBackgroundResource(R.mipmap.default_indicator);
                indTwo.setBackgroundResource(R.mipmap.selected_indicator);
                indThree.setBackgroundResource(R.mipmap.default_indicator);
                break;
            case 2:
                indOne.setBackgroundResource(R.mipmap.default_indicator);
                indTwo.setBackgroundResource(R.mipmap.default_indicator);
                indThree.setBackgroundResource(R.mipmap.selected_indicator);
                break;

        }

    }


    public void showMenuSelected(int position, float positionOffset) {
        switch (position){
            case 0:
                menu.setBackgroundColor(Color.argb(255,Math.round(214*positionOffset),Math.round(87-(87-45)*positionOffset),Math.round(231-(231-32)*positionOffset)));
                break;
            case 1 :
                menu.setBackgroundColor(Color.argb(255,Math.round(214+(255-214)*positionOffset),Math.round(45+(167-45)*positionOffset),Math.round(32+(0-32)*positionOffset)));
                break;
            case 2 :
                menu.setBackgroundResource(R.color.yellow);
                break;
        }

        percentSelection = position + 1.0f + positionOffset;
        params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, percentSelection);
        menuSelected.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_one:
                pager.setCurrentItem(0);
                break;
            case R.id.tv_two:
                pager.setCurrentItem(1);
                break;
            case R.id.tv_third:
                pager.setCurrentItem(2);
                break;
        }
    }
}
