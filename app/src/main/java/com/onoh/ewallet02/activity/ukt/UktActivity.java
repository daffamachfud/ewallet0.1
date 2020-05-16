package com.onoh.ewallet02.activity.ukt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.onoh.ewallet02.R;
import com.onoh.ewallet02.model.Universitas;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UktActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleViewUktAdapter adapter;
    private ArrayList<Universitas> universitasArrayList;

    @BindView(R.id.toolbar_ukt)
    Toolbar toolbar_ukt;

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

        //backbutton
        toolbar_ukt.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }




    public void loadDataUniv(){
        universitasArrayList = new ArrayList<>();
        universitasArrayList.add(new Universitas(R.drawable.ic_logopolban,getString(R.string.nama_polban)));
        universitasArrayList.add(new Universitas(R.drawable.ic_logopolban,getString(R.string.nama_ui)));

    }
}
