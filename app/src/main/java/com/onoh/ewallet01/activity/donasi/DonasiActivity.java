package com.onoh.ewallet01.activity.donasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.onoh.ewallet01.R;
import com.onoh.ewallet01.activity.event.EventActivity;
import com.onoh.ewallet01.activity.event.RecycleViewEventAdapter;
import com.onoh.ewallet01.model.Donasi;
import com.onoh.ewallet01.model.Event;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class DonasiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleViewDonasiAdapter adapter;
    private ArrayList<Donasi> donasiArrayList;

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
    }


    public void loadDataDonasi(){
        donasiArrayList = new ArrayList<>();
        donasiArrayList.add(new Donasi(R.drawable.posterevent1,"Donasi Makanan","10 Desember 2020","Rp.3.000.000",getString(R.string.contoh_deskripsi_event)));
    }
}
