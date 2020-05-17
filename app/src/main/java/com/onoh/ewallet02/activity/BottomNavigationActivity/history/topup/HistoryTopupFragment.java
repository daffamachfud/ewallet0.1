package com.onoh.ewallet02.activity.BottomNavigationActivity.history.topup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onoh.ewallet02.R;
import com.onoh.ewallet02.activity.BottomNavigationActivity.history.pembayaran.RecycleViewHistoryPembayaranAdapter;
import com.onoh.ewallet02.activity.donasi.DonasiActivity;
import com.onoh.ewallet02.activity.donasi.RecycleViewDonasiAdapter;
import com.onoh.ewallet02.model.Donasi;
import com.onoh.ewallet02.model.HistoryPembayaran;
import com.onoh.ewallet02.model.HistoryTopup;

import java.util.ArrayList;
import java.util.List;


public class HistoryTopupFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecycleViewHistoryTopupAdapter adapter;
    private ArrayList<HistoryTopup> datahistoryTopupArrayList;
    View v;


    public HistoryTopupFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_history_topup,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.list_history_topup);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        adapter = new RecycleViewHistoryTopupAdapter(datahistoryTopupArrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datahistoryTopupArrayList = new ArrayList<>();
        datahistoryTopupArrayList.add(new HistoryTopup("20 Desember 2020","08:00","Merchant","+Rp.30.000","Berhasil","0000000"));
        datahistoryTopupArrayList.add(new HistoryTopup("21 Desember 2020","09:00","Transfer","+Rp.100.000","Berhasil","1111111"));
        datahistoryTopupArrayList.add(new HistoryTopup("24 Desember 2020","11:00","Transfer","+Rp.20.000","Gagal","1111111"));


    }


}
