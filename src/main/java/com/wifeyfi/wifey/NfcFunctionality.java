package com.wifeyfi.wifey;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NfcFunctionality extends AppCompatActivity implements OutcomingNfcManager.NfcActivity{
    private TextView tvOutcomingMessage;
    private EditText Password;
    private EditText ssid;
    private Button btnSetOutcomingMessage, receiveNfcTransfer;

    private NfcAdapter nfcAdapter;
    private OutcomingNfcManager outcomingNfccallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc_functionality);

        receiveNfcTransfer = (Button) findViewById(R.id.receive_nfc_transfer_btn);
        receiveNfcTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReceiveNfcTransfer();

            }
        });

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (!isNfcSupported()) {
            Toast.makeText(getApplicationContext(), "Nfc is not supported on this device", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (!nfcAdapter.isEnabled()) {
            Toast.makeText(getApplicationContext(), "NFC disabled on this device. Turn on to proceed", Toast.LENGTH_SHORT).show();
        }

        initViews();

        // encapsulate sending logic in a separate class
        this.outcomingNfccallback = new OutcomingNfcManager(this);
        this.nfcAdapter.setOnNdefPushCompleteCallback(outcomingNfccallback, this);
        this.nfcAdapter.setNdefPushMessageCallback(outcomingNfccallback, this);
    }

    private void openReceiveNfcTransfer() {
        Intent intent = new Intent(this, ReceiveNfcTransfer.class);
        startActivity(intent);
    }

    private void initViews() {
        this.tvOutcomingMessage = (TextView) findViewById(R.id.tv_out_message);
        this.Password = (EditText) findViewById(R.id.et_message);
        this.ssid = (EditText) findViewById(R.id.et_message2);

        this.btnSetOutcomingMessage = (Button) findViewById(R.id.btn_set_out_message);
        this.btnSetOutcomingMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOutGoingMessage();

            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
    }

    private boolean isNfcSupported() {
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        return this.nfcAdapter != null;
    }

    private void setOutGoingMessage() {
        String outMessage = this.ssid.getText().toString()+"@"+this.Password.getText().toString();
        this.tvOutcomingMessage.setText(outMessage);
    }

    @Override
    public String getOutcomingMessage() {
        return this.tvOutcomingMessage.getText().toString();
    }

    @Override
    public void signalResult() {
        // this will be triggered when NFC message is sent to a device.
        // should be triggered on UI thread. We specify it explicitly
        // cause onNdefPushComplete is called from the Binder thread
        //runOnUiThread( Toast.makeText(SenderActivity.this, R.string.message_beaming_complete, Toast.LENGTH_SHORT).show());

        runOnUiThread (new Thread(new Runnable() {
            public void run() {
                Toast.makeText(NfcFunctionality.this, R.string.message_beaming_complete, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}


