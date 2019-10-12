package com.androidtutorialpoint.qrcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NfcFunctionality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc_functionality);

        Button nfcBtn= (Button) findViewById(R.id.writeToNfcBtn);


        nfcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNfcFunctionality();

            }
        });

    }
    public void openNfcFunctionality(){
        Intent intent = new Intent(this, SenderActivity.class);
        startActivity(intent);
    }
}
