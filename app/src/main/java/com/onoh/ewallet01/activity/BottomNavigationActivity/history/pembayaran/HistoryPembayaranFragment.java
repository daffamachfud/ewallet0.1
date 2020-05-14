package com.onoh.ewallet01.activity.BottomNavigationActivity.history.pembayaran;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onoh.ewallet01.R;
import com.onoh.ewallet01.model.ListHistoryPembayaran;

import java.util.ArrayList;
import java.util.List;


public class HistoryPembayaranFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<ListHistoryPembayaran> listChats;

    public HistoryPembayaranFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_history_pembayaran,container,false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.list_history_pembayaran);
        RecycleViewPembayaranAdapter recycleViewAdapter = new RecycleViewPembayaranAdapter(getContext(),listChats);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recycleViewAdapter);

        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listChats = new ArrayList<>();
        listChats.add(new ListHistoryPembayaran("20 September 2020","TOKO BAWANG","Rp.20.000"));
        listChats.add(new ListHistoryPembayaran("20 September 2020","TOKO BAWANG","Rp.20.000"));
        listChats.add(new ListHistoryPembayaran("20 September 2020","TOKO BAWANG","Rp.20.000"));
        listChats.add(new ListHistoryPembayaran("20 September 2020","TOKO BAWANG","Rp.20.000"));
        listChats.add(new ListHistoryPembayaran("20 September 2020","TOKO BAWANG","Rp.20.000"));

    }
}
