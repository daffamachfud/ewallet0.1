package com.onoh.ewallet01.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.onoh.ewallet01.R;

public class MainActivity extends AppCompatActivity {

    TextView tvNama;
    String resNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            resNama = extras.getString("result_nama");
            tvNama.setText(resNama);
        }
    }

    private void initComponent() {
        tvNama = (TextView) findViewById(R.id.tv_name);

    }
}
