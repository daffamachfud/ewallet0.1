package com.onoh.ewallet02.activity.BottomNavigationActivity.history.topup;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.onoh.ewallet02.R;
import com.onoh.ewallet02.model.HistoryTopup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewHistoryTopupAdapter extends RecyclerView.Adapter<RecycleViewHistoryTopupAdapter.TopupViewHolder> {

    private ArrayList<HistoryTopup> dataHistoryTopup;

    public RecycleViewHistoryTopupAdapter(ArrayList<HistoryTopup> dataHistoryTopup) {
        this.dataHistoryTopup = dataHistoryTopup;
    }

    @NotNull
    @Override
    public RecycleViewHistoryTopupAdapter.TopupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_history_topup, parent, false);
        return new RecycleViewHistoryTopupAdapter.TopupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewHistoryTopupAdapter.TopupViewHolder holder, int position) {
        holder.tv_ket_topup_history.setText(dataHistoryTopup.get(position).getTipeTopup());
        holder.tv_tgl_topup_history.setText(dataHistoryTopup.get(position).getTanggal());
        holder.tv_waktu_topup_history.setText(dataHistoryTopup.get(position).getWaktu());
        holder.tv_nominal_history_topup.setText(dataHistoryTopup.get(position).getNominal());
        holder.cv_topup_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailHistoryTopup.class);
                mIntent.putExtra("tipeTopup", dataHistoryTopup.get(position).getTipeTopup());
                mIntent.putExtra("tglTopup", dataHistoryTopup.get(position).getTanggal());
                mIntent.putExtra("waktuTopup", dataHistoryTopup.get(position).getWaktu());
                mIntent.putExtra("idTransaksi", dataHistoryTopup.get(position).getIdTransaksi());
                mIntent.putExtra("nominalTopup", dataHistoryTopup.get(position).getNominal());
                mIntent.putExtra("status", dataHistoryTopup.get(position).getStatus());
                view.getContext().startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (dataHistoryTopup != null) ? dataHistoryTopup.size() : 0;
    }

    public static class TopupViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_ket_topup_history, tv_tgl_topup_history, tv_waktu_topup_history,tv_nominal_history_topup;
        private CardView cv_topup_history;

        public TopupViewHolder(View itemView) {
            super(itemView);
            tv_ket_topup_history = (TextView) itemView.findViewById(R.id.tv_ket_topup_history);
            tv_tgl_topup_history = (TextView) itemView.findViewById(R.id.tv_tanggal_topup_history);
            tv_waktu_topup_history = (TextView) itemView.findViewById(R.id.tv_waktu_topup_history);
            tv_nominal_history_topup = (TextView) itemView.findViewById(R.id.tv_nominal_topup_history);
            cv_topup_history = (CardView) itemView.findViewById(R.id.cv_history_topup);

        }
    }

}

