package com.wifeyfi.wifey;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;




public class HomePage extends AppCompatActivity {

    private Button nfcButton, qrCodeButton, hamburger;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

      MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        hamburger = (Button) findViewById(R.id.hamburger);
        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPremiumFeatureAndDonation();

            }
        });

        // Assign views from the layout file to the corresponding variables created
        nfcButton = (Button) findViewById(R.id.nfc_btn_main);
        qrCodeButton = (Button) findViewById(R.id.qr_code_btn_main);

        ImageView wifiBarOne = (ImageView) findViewById(R.id.wifey_wifi_bar_one);
        ImageView wifiBarTwo = (ImageView) findViewById(R.id.wifey_wifi_bar_two);
        wifiBarOne.animate().alpha(0.2f).setDuration(1000);
        wifiBarTwo.animate().alpha(0.2f).setDuration(2000);

        qrCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQrCode();

            }
        });
        nfcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNfc();

            }
        });

    }

    private void openPremiumFeatureAndDonation() {
        Intent intent = new Intent(this, PremiumFeatureAndDonation.class);
        startActivity(intent);
    }
    public void openNfc() {
        Intent intent = new Intent(this, NfcFunctionality.class);
        startActivity(intent);
    }

    public void openQrCode() {
        Intent intent = new Intent(this, QrGenerator.class);
        startActivity(intent);
    }
}
