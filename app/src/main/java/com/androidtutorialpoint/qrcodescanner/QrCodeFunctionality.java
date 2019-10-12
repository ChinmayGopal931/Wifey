package com.androidtutorialpoint.qrcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class QrCodeFunctionality extends AppCompatActivity {

    private Button generateQrButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_functionality);

        // assign generateQrButton variable with the button generateQrButton typecast it to button
     /*   generateQrButton = (Button) findViewById(R.id.generateQrButton);

        // set function of generateQrButton when clicked
        generateQrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGenerateQrPage();
            }
        });*/


    }
   /* public void openGenerateQrPage(){
        Intent intent = new Intent(this, GenerateQrPage.class);
        startActivity(intent);
    }*/

}
