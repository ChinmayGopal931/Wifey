package com.androidtutorialpoint.qrcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class QrCodeFunctionality2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrcodenew);


        Button qrGen = (Button) findViewById(R.id.qrCodeBtn3);
        Button qrScan = (Button) findViewById(R.id.qrCodeBtn2);


        qrScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQrCode();

            }
        });
        qrGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openqrgeneratingactivity();

            }
        });
    }
    public void openQrCode() {
        Intent intent = new Intent(this, QrCodeScannerActivity.class);
        startActivity(intent);
    }
    public void qrGen() {
        Intent intent = new Intent(this, GenerateQrPage.class);
        startActivity(intent);
    }
    public void openqrgeneratingactivity(){
        Intent intent = new Intent(this, qrgeneratingactivity.class);
        startActivity(intent);
    }
}
