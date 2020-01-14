package com.wifeyfi.wifey;

import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
//import com.journeyapps.barcodescanner.BarcodeEncoder;


public class QrGenerator extends AppCompatActivity {

    private ImageView generatedqr;
    private EditText qrtext;
    private Button generatebtn, scanQrBtn;
    private String text2Qr;
    private Button savedWifiNetworks, shareQrCode, addToSavedWifiNetworks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generator);

        scanQrBtn = (Button) findViewById(R.id.scan_qr_code_btn);
        scanQrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQrScan();

            }
        });

        savedWifiNetworks = (Button) findViewById(R.id.saved_wifi_networks);
        savedWifiNetworks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPremiumFeatureAndDonation();

            }
        });

        shareQrCode = (Button) findViewById(R.id.share_qr_code);
        shareQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPremiumFeatureAndDonation();

            }
        });

        addToSavedWifiNetworks = (Button) findViewById(R.id.add_to_saved_wifi_networks);
        addToSavedWifiNetworks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPremiumFeatureAndDonation();

            }
        });

        qrtext = (EditText) findViewById(R.id.qrtext1);
        final EditText qrtext2 = (EditText) findViewById(R.id.qrtext2);
        generatedqr = (ImageView) findViewById(R.id.generatedqr);
        generatebtn = (Button) findViewById(R.id.generatebtn);
        generatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2Qr = "WIFI:T:WPA;S:" + qrtext.getText().toString() + ";P:" + qrtext2.getText().toString() + ";;";
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE,150,150);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    generatedqr.setImageBitmap(bitmap);
                }
                catch (WriterException e){
                    e.printStackTrace();
                }


            }
        });


    }

    private void openPremiumFeatureAndDonation() {
        Intent intent = new Intent(this, PremiumFeatureAndDonation.class);
        startActivity(intent);
    }

    public void openQrScan() {
        Intent intent = new Intent(this, QrScanner.class);
        startActivity(intent);
    }
}