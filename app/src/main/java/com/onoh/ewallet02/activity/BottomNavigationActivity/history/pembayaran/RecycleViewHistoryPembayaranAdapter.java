package com.onoh.ewallet02.activity.BottomNavigationActivity.history.pembayaran;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.onoh.ewallet02.R;
import com.onoh.ewallet02.activity.BottomNavigationActivity.history.topup.DetailHistoryTopup;
import com.onoh.ewallet02.activity.BottomNavigationActivity.history.topup.RecycleViewHistoryTopupAdapter;
import com.onoh.ewallet02.activity.donasi.DetailDonasiActivity;
import com.onoh.ewallet02.model.HistoryPembayaran;
import com.onoh.ewallet02.model.HistoryTopup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewHistoryPembayaranAdapter extends RecyclerView.Adapter<RecycleViewHistoryPembayaranAdapter.PembayaranHistoryViewHolder> {

    private ArrayList<HistoryPembayaran> dataHistoryPembayaran;

    public RecycleViewHistoryPembayaranAdapter(ArrayList<HistoryPembayaran> dataHistoryPembayaran) {
        this.dataHistoryPembayaran = dataHistoryPembayaran;
    }

    @NotNull
    @Override
    public RecycleViewHistoryPembayaranAdapter.PembayaranHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_history_pembayaran, parent, false);
        return new RecycleViewHistoryPembayaranAdapter.PembayaranHistoryViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecycleViewHistoryPembayaranAdapter.PembayaranHistoryViewHolder holder, int position) {
        holder.tv_ketPembayaran.setText(dataHistoryPembayaran.get(position).getTipe());
        holder.tv_tanggal_history.setText(dataHistoryPembayaran.get(position).getTanggal());
        holder.tv_waktu_history.setText(dataHistoryPembayaran.get(position).getWaktu());
        holder.tv_nominal_history.setText(dataHistoryPembayaran.get(position).getNominal());
        holder.cv_history_pembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailHistoryPembayaran.class);
                mIntent.putExtra("ketPembayaran", dataHistoryPembayaran.get(position).getTipe());
                mIntent.putExtra("tanggal", dataHistoryPembayaran.get(position).getTanggal());
                mIntent.putExtra("waktu", dataHistoryPembayaran.get(position).getWaktu());
                mIntent.putExtra("nominal",dataHistoryPembayaran.get(position).getNominal());
                mIntent.putExtra("tempat",dataHistoryPembayaran.get(position).getTujuan());
                mIntent.putExtra("status",dataHistoryPembayaran.get(position).getStatus());
                mIntent.putExtra("idTransaksi",dataHistoryPembayaran.get(position).getIdTransaksi());
                view.getContext().startActivity(mIntent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return (dataHistoryPembayaran != null) ? dataHistoryPembayaran.size() : 0;
    }

    public static class PembayaranHistoryViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_ketPembayaran,tv_tanggal_history,tv_waktu_history,tv_nominal_history;
        private CardView cv_history_pembayaran;

        public PembayaranHistoryViewHolder(View itemView) {
            super(itemView);
            tv_ketPembayaran = (TextView) itemView.findViewById(R.id.ket_pembayaran);
            tv_tanggal_history = (TextView) itemView.findViewById(R.id.tanggal_transaksi);
            tv_waktu_history = (TextView) itemView.findViewById(R.id.waktu_transaksi);
            tv_nominal_history = (TextView) itemView.findViewById(R.id.nominal_transaksi_history);
            cv_history_pembayaran = (CardView) itemView.findViewById(R.id.cv_history_pembayaran);

        }
    }


}

