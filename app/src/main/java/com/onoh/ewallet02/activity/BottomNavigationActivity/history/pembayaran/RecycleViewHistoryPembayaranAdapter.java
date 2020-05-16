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
import com.onoh.ewallet02.activity.donasi.DetailDonasiActivity;
import com.onoh.ewallet02.model.HistoryPembayaran;

import java.util.List;

public class RecycleViewHistoryPembayaranAdapter extends RecyclerView.Adapter<RecycleViewHistoryPembayaranAdapter.MyViewHolder> {

    Context mContext;
    List<HistoryPembayaran> mData;

    public RecycleViewHistoryPembayaranAdapter(Context mContext, List<HistoryPembayaran> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_list_history_pembayaran,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_ketPembayaran.setText(mData.get(position).getTipe());
        holder.tv_tanggal_history.setText(mData.get(position).getTanggal());
        holder.tv_waktu_history.setText(mData.get(position).getWaktu());
        holder.tv_nominal_history.setText(mData.get(position).getNominal());
        holder.cv_history_pembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailHistoryPembayaran.class);
                mIntent.putExtra("ketPembayaran", mData.get(position).getTipe());
                mIntent.putExtra("tanggal", mData.get(position).getTanggal());
                mIntent.putExtra("waktu", mData.get(position).getWaktu());
                mIntent.putExtra("nominal",mData.get(position).getNominal());
                mIntent.putExtra("tempat",mData.get(position).getTujuan());
                mIntent.putExtra("status",mData.get(position).getStatus());
                mIntent.putExtra("idTransaksi",mData.get(position).getIdTransaksi());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_ketPembayaran,tv_tanggal_history,tv_waktu_history,tv_nominal_history;
        private CardView cv_history_pembayaran;

        public MyViewHolder(View itemView) {

            super(itemView);

            tv_ketPembayaran = (TextView) itemView.findViewById(R.id.ket_pembayaran);
            tv_tanggal_history = (TextView) itemView.findViewById(R.id.tanggal_transaksi);
            tv_waktu_history = (TextView) itemView.findViewById(R.id.waktu_transaksi);
            tv_nominal_history = (TextView) itemView.findViewById(R.id.nominal_transaksi_history);
            cv_history_pembayaran = (CardView) itemView.findViewById(R.id.cv_history_pembayaran);
        }
    }

}

