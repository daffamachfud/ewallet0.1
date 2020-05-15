package com.onoh.ewallet01.activity.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.onoh.ewallet01.R;
import com.onoh.ewallet01.activity.ukt.RecycleViewUktAdapter;
import com.onoh.ewallet01.activity.ukt.UktActivity;
import com.onoh.ewallet01.model.Event;
import com.onoh.ewallet01.model.Universitas;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class EventActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleViewEventAdapter adapter;
    private ArrayList<Event> eventArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);
        loadDataEvent();
        recyclerView = (RecyclerView) findViewById(R.id.list_event);
        adapter = new RecycleViewEventAdapter(eventArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EventActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    public void loadDataEvent(){
        eventArrayList = new ArrayList<>();
        eventArrayList.add(new Event(R.drawable.posterevent1,"Konser Amal",getString(R.string.nama_polban),"10 Desember 2020","Konser",getString(R.string.contoh_deskripsi_event)));
    }
}
