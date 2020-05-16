package com.onoh.ewallet02.activity.donasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.onoh.ewallet02.R;
import com.onoh.ewallet02.model.Donasi;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DonasiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleViewDonasiAdapter adapter;
    private ArrayList<Donasi> donasiArrayList;

    @BindView(R.id.toolbar_donasi)
    Toolbar toolbar_donasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi);
        ButterKnife.bind(this);
        loadDataDonasi();
        recyclerView = (RecyclerView) findViewById(R.id.list_donasi);
        adapter = new RecycleViewDonasiAdapter(donasiArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DonasiActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //backbutton
        toolbar_donasi.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    public void loadDataDonasi(){
        donasiArrayList = new ArrayList<>();
        donasiArrayList.add(new Donasi(R.drawable.posterevent1,"Donasi Makanan","10 Desember 2020","Rp.3.000.000",getString(R.string.contoh_deskripsi_event)));
        donasiArrayList.add(new Donasi(R.drawable.posterevent1,"Donasi Makanan","10 Desember 2020","Rp.3.000.000",getString(R.string.contoh_deskripsi_event)));
        donasiArrayList.add(new Donasi(R.drawable.posterevent1,"Donasi Makanan","10 Desember 2020","Rp.3.000.000",getString(R.string.contoh_deskripsi_event)));

    }
}
