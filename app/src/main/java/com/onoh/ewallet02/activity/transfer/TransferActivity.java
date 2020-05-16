package com.onoh.ewallet02.activity.transfer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.onoh.ewallet02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransferActivity extends AppCompatActivity  {

    @BindView(R.id.btn_transfer_qrcode)
    ImageButton btnTransferQrcode;
    @BindView(R.id.btn_trasnfer_noTelpn)
    ImageButton btnTransferNotelepon;
    @BindView(R.id.toolbar_transfer)
    Toolbar toolbar_transfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        ButterKnife.bind(this);

        btnTransferQrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IntentIntegrator(TransferActivity.this).setCaptureActivity(TransferQrcodeActivity.class).initiateScan();
            }
        });

        btnTransferNotelepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_trasnfer_noTelpn = new Intent(TransferActivity.this,TransferNomorActivity.class);
                startActivity(intent_trasnfer_noTelpn);
            }
        });


        //back button toolbar
        toolbar_transfer.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //We will get scan results here
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check for null
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Scan Cancelled", Toast.LENGTH_LONG).show();
            } else {
                //show dialogue with result
                showResultDialogueTransfer(result.getContents());
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }



    //method to construct dialogue pemabayran
    public void showResultDialogueTransfer(final String result) {

        //intent ke halaman detail payment
        Intent intent_detail_transfer = new Intent(this, TransferDetailActivity.class);
        intent_detail_transfer.putExtra("hasilscantransfer",result);
        startActivity(intent_detail_transfer);

//
    }
    //end shoResultDialoguePemabayran






}
