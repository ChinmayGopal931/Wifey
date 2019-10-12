package com.androidtutorialpoint.qrcodescanner;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
//import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qrgeneratingactivity extends AppCompatActivity {

    private ImageView generatedqr;
    private EditText qrtext;
    private Button generatebtn;
    private String text2Qr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrgeneratingactivity);


        qrtext = (EditText) findViewById(R.id.qrtext1);
        final EditText qrtext2 = (EditText) findViewById(R.id.qrtext2);
        generatedqr = (ImageView) findViewById(R.id.generatedqr);
        generatebtn = (Button) findViewById(R.id.generatebtn);
        generatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2Qr = qrtext.getText().toString()+"@"+qrtext2.getText().toString();
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
}
