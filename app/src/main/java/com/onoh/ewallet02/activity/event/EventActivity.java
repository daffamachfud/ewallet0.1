package com.onoh.ewallet02.activity.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.onoh.ewallet02.R;
import com.onoh.ewallet02.model.Event;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleViewEventAdapter adapter;
    private ArrayList<Event> eventArrayList;
    @BindView(R.id.toolbar_event)
    Toolbar toolbar_event;

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

        //backpressed
        toolbar_event.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    public void loadDataEvent(){
        eventArrayList = new ArrayList<>();
        eventArrayList.add(new Event(R.drawable.posterevent1,"Konser Amal",getString(R.string.nama_polban),"10 Desember 2020","Konser",getString(R.string.contoh_deskripsi_event)));
    }
}
