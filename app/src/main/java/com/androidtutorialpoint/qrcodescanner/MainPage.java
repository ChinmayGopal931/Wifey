package com.androidtutorialpoint.qrcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainPage extends AppCompatActivity {

    // Declaring view variables
    private Button nfcButton, qrCodeButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

         // Assign views from the layout file to the corresponding variables you created
        nfcButton = (Button) findViewById(R.id.nfcButton);
        qrCodeButton = (Button) findViewById(R.id.qrCodeBtn);


        nfcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNfcFunctionality();

            }
        });
        qrCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQrCode();

            }
        });
        }
    public void openQrCode() {
        Intent intent = new Intent(this, QrCodeFunctionality2.class);
        startActivity(intent);
    }
    public void openNfcFunctionality() {
        Intent intent = new Intent(this, NfcFunctionality.class);
        startActivity(intent);
    }



}
