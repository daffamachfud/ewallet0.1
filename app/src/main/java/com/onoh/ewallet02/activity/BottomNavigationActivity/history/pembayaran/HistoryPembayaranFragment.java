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
import com.onoh.ewallet02.model.HistoryPembayaran;

import java.util.ArrayList;
import java.util.List;


public class HistoryPembayaranFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<HistoryPembayaran> listHistoryPembayaran;

    public HistoryPembayaranFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_history_pembayaran,container,false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.list_history_pembayaran);
        RecycleViewHistoryPembayaranAdapter recycleViewAdapter = new RecycleViewHistoryPembayaranAdapter(getContext(),listHistoryPembayaran);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recycleViewAdapter);

        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listHistoryPembayaran = new ArrayList<>();
        listHistoryPembayaran.add(new HistoryPembayaran("20 Desember 2020","08:00","Pembayaran Pujas","Toko Geprek","-Rp.200.000","Berhasil","12345678"));
        listHistoryPembayaran.add(new HistoryPembayaran("20 Desember 2020","08:00","Pembayaran Pujas","Toko Geprek","-Rp.200.000","Berhasil","12345678"));
        listHistoryPembayaran.add(new HistoryPembayaran("20 Desember 2020","08:00","Pembayaran Pujas","Toko Geprek","-Rp.200.000","Berhasil","12345678"));

    }
}
