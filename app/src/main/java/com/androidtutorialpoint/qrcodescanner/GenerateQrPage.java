package com.androidtutorialpoint.qrcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GenerateQrPage extends AppCompatActivity {

    private Button shareqrbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr_page);

        shareqrbutton = (Button) findViewById(R.id.shareqrbtn);
        shareqrbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openqrgeneratingactivity();
            }
        });

    }

    public void openqrgeneratingactivity(){
        Intent intent = new Intent(this, qrgeneratingactivity.class);
        startActivity(intent);
    }
}
