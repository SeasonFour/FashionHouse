package com.ellekay.lucie.fashionhouse;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    //create splashie time-out
    public static int SPLASH_TIME_OUT =2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(Splash.this, Appintro.class);
                startActivity(i);
                finish();

            }

        }, SPLASH_TIME_OUT);

    }
}
