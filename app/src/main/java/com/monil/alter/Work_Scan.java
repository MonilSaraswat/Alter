package com.monil.alter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

/**
 * Created by hp 15 on 8/4/2017.
 */

public class Work_Scan extends AppCompatActivity {
    TextView textView ;
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Work_Scan.this , MainActivity.class));
        super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_work_scan);
        textView = (TextView)findViewById(R.id.number);

        Intent intent = new Intent(Work_Scan.this , Scan.class);
        startActivityForResult(intent, 0);



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode==0){
            if (requestCode == CommonStatusCodes.SUCCESS){
                if(data != null){
                    Barcode barcode = data.getParcelableExtra("barcode");
                    textView.setText(barcode.displayValue);

                }
                else{
                    textView.setText("No Barcode Found");
                }
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}



