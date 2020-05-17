package com.onoh.ewallet02.activity.BottomNavigationActivity.history.pembayaran;

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
import com.onoh.ewallet02.activity.BottomNavigationActivity.history.topup.RecycleViewHistoryTopupAdapter;
import com.onoh.ewallet02.model.HistoryPembayaran;
import com.onoh.ewallet02.model.HistoryTopup;

import java.util.ArrayList;
import java.util.List;


public class HistoryPembayaranFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecycleViewHistoryPembayaranAdapter adapter;
    private ArrayList<HistoryPembayaran> datahistoryPembayaranArrayList;
    View v;


    public HistoryPembayaranFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_history_pembayaran,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.list_history_pembayaran);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        adapter = new RecycleViewHistoryPembayaranAdapter(datahistoryPembayaranArrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        datahistoryPembayaranArrayList = new ArrayList<>();
        datahistoryPembayaranArrayList.add(new HistoryPembayaran("20 Desember 2020","08:00","Pembayaran Pujas","Toko Geprek","-Rp.200.000","Berhasil","12345678"));
        datahistoryPembayaranArrayList.add(new HistoryPembayaran("22 Desember 2020","09:00","Donasi","Bantuan Air","-Rp.100.000","Gagal","4567890"));

    }
}
