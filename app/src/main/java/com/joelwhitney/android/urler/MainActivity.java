package com.joelwhitney.android.urler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import com.joelwhitney.android.urler.scan_activity.ScanActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int BARCODE_READER_REQUEST_CODE = 0;

    private TextView mResultTextView;
    private Button mScanBarcodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultTextView = findViewById(R.id.result_textview);
        mScanBarcodeButton = findViewById(R.id.scan_barcode_button);

        mScanBarcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"button clicked");
                Intent intent = ScanActivity.newIntent(MainActivity.this);
                startActivityForResult(intent, BARCODE_READER_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BARCODE_READER_REQUEST_CODE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(ScanActivity.BarcodeObject);
                    //val p = barcode.cornerPoints
                    mResultTextView.setText(barcode.displayValue);
                } else
                    mResultTextView.setText(R.string.no_barcode_captured);
            } else
                Log.e(TAG, "Error");
        }
    }
}
