package com.onoh.ewallet01.activity.ukt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.onoh.ewallet01.R;
import com.onoh.ewallet01.model.Universitas;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class UktActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleViewUktAdapter adapter;
    private ArrayList<Universitas> universitasArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ukt);
        ButterKnife.bind(this);
        loadDataUniv();
        recyclerView = (RecyclerView) findViewById(R.id.list_universitas);
        adapter = new RecycleViewUktAdapter(universitasArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(UktActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }




    public void loadDataUniv(){
        universitasArrayList = new ArrayList<>();
        universitasArrayList.add(new Universitas(R.drawable.ic_logopolban,"POLBAN"));
        universitasArrayList.add(new Universitas(R.drawable.ic_logopolban,"UI"));

    }
}
