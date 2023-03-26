package com.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActiivity extends AppCompatActivity {

    int time = 8000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_actiivity);

        GifImageView gifImageView = findViewById(R.id.gif_img);
        gifImageView.setGifImageResource(R.drawable.gif_img);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActiivity.this, CurrencyConvert.class);
                startActivity(i);
                finish();
            }
        }, time);
    }
}