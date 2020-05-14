package com.onoh.ewallet01.activity.ukt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.onoh.ewallet01.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FormUktActivity extends AppCompatActivity {

public String namaUniv;
int gambarUniv;

@BindView(R.id.img_form_univ)
    ImageView imgUniv;
@BindView(R.id.btnSubmitUkt)
    Button btnsubmitUkt;
@BindView(R.id.etMasukanNim)
    TextInputEditText etMasukanNim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ukt);
        ButterKnife.bind(this);
        getData();

        btnsubmitUkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSubmitUkt = new Intent(FormUktActivity.this,KonfirmUktActivity.class);
                intentSubmitUkt.putExtra("nim", Objects.requireNonNull(etMasukanNim.getText()).toString());
                intentSubmitUkt.putExtra("namaUniv", namaUniv);
                intentSubmitUkt.putExtra("gambarUniv",gambarUniv);
                startActivity(intentSubmitUkt);
            }
        });

    }


    public void getData(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            namaUniv = extras.getString("namaUniv");
            gambarUniv = getIntent().getIntExtra("gambarUniv",0);
            imgUniv.setImageResource(gambarUniv);
            imgUniv.setVisibility(View.GONE);
        }
    }
}
