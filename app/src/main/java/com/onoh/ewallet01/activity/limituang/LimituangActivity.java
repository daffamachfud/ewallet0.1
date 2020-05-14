package com.onoh.ewallet01.activity.limituang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.onoh.ewallet01.R;
import com.onoh.ewallet01.model.MoneyTextWatcher;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LimituangActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_limituang)
    Toolbar toolbar_limit;
    @BindView(R.id.etMasukanLimit)
    TextInputEditText etNominalLimit;
    @BindView(R.id.btn_setlimit)
    Button btn_limit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limituang);
        ButterKnife.bind(this);

        //back button toolbar
        toolbar_limit.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //set format nominal
        etNominalLimit.addTextChangedListener(new MoneyTextWatcher(etNominalLimit));

        btn_limit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fungsi limit
                String limit = Objects.requireNonNull(etNominalLimit.getText()).toString();
                Toast.makeText(LimituangActivity.this, "Limit yang diatur : " + limit, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
