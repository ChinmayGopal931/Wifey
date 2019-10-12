package com.androidtutorialpoint.qrcodescanner;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity  {
    private static int TIME_OUT = 1000;

    TextView tvSplash;


    @Override
    @TargetApi(11)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View myLayout = findViewById(R.id.imageView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, MainPage.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);

        tvSplash = (TextView) findViewById(R.id.tvSplash);


        //import font

        Typeface typeface = getResources().getFont(R.font.cornerstone);

        //customize font
        tvSplash.setTypeface(typeface);

    }



}
