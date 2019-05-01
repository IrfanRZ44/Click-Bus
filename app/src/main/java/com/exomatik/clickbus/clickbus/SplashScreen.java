package com.exomatik.clickbus.clickbus;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    private UserPreference mUserPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mUserPreferences = new UserPreference(this);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                if (mUserPreferences.getKEY_NAME()){
                    Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(homeIntent);
                    finish();
                }else {
                    Intent homeIntent = new Intent(SplashScreen.this, OnBoard.class);
                    startActivity(homeIntent);
                    finish();
                }
            }
        },3000);
    }
}
