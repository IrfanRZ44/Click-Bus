package com.exomatik.clickbus.clickbus;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator;

public class OnBoard extends AppCompatActivity {
    private ViewPager vpBoard;
    private SwipeAdapter swipeAdapter;
    private CircleIndicator indicator;
    private RelativeLayout rlBoard, rlNext, rlBack;
    private UserPreference mUserPreferences;
    private TextView textNext, textBack;
    private int posisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);

        vpBoard = (ViewPager) findViewById(R.id.vp_board);
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        rlBoard = (RelativeLayout) findViewById(R.id.rl_board);
        rlNext = (RelativeLayout) findViewById(R.id.rl_next);
        textNext = (TextView) findViewById(R.id.text_next);
        rlBack = (RelativeLayout) findViewById(R.id.rl_back);
        textBack = (TextView) findViewById(R.id.text_back);

        mUserPreferences = new UserPreference(this);
        swipeAdapter = new SwipeAdapter(this);
        vpBoard.setOffscreenPageLimit(1);
        vpBoard.setAdapter(swipeAdapter);

        indicator.setViewPager(vpBoard);

        vpBoard.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0){
                    rlBack.setVisibility(View.GONE);

                    textNext.setTextColor(getResources().getColor(R.color.step1));
                    textNext.setText("Selanjutnya");
                    rlBoard.setBackgroundResource(R.color.step1);
                }else if (position == 1){
                    rlBack.setVisibility(View.VISIBLE);
                    textBack.setTextColor(getResources().getColor(R.color.step2));

                    textNext.setTextColor(getResources().getColor(R.color.step2));
                    textNext.setText("Selanjutnya");
                    rlBoard.setBackgroundResource(R.color.step2);
                }else if (position == 2){
                    rlBack.setVisibility(View.VISIBLE);
                    textBack.setTextColor(getResources().getColor(R.color.step3));

                    textNext.setTextColor(getResources().getColor(R.color.step3));
                    textNext.setText("Selesai");
                    rlBoard.setBackgroundResource(R.color.step3);
                }
                posisi = position;
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posisi--;
                vpBoard.setCurrentItem(posisi);
            }
        });

        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNext.getText().toString().equals("Selesai")){
                    mUserPreferences.setKEY_NAME(true);
                    Intent homeIntent = new Intent(OnBoard.this, MainActivity.class);
                    startActivity(homeIntent);
                    finish();
                }else{
                    posisi++;
                    vpBoard.setCurrentItem(posisi);
                }
            }
        });
    }
}
