package com.onoh.ewallet01.activity.BottomNavigationActivity.history.pembayaran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.onoh.ewallet01.R;
import com.onoh.ewallet01.model.ListHistoryPembayaran;

import java.util.List;

public class RecycleViewPembayaranAdapter extends RecyclerView.Adapter<RecycleViewPembayaranAdapter.MyViewHolder> {

    Context mContext;
    List<ListHistoryPembayaran> mData;

    public RecycleViewPembayaranAdapter(Context mContext, List<ListHistoryPembayaran> mData) {
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

        holder.tv_tanggal_history.setText(mData.get(position).getTanggal());
        holder.tv_tujuan.setText(mData.get(position).getTujuan());
        holder.tv_nominal.setText(mData.get(position).getNominal());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_tanggal_history;
        private TextView tv_tujuan;
        private TextView tv_nominal;

        public MyViewHolder(View itemView) {

            super(itemView);

            tv_tanggal_history = (TextView) itemView.findViewById(R.id.item_list_tanggal);
            tv_tujuan = (TextView) itemView.findViewById(R.id.item_ket_pembayaran_ke);
            tv_nominal = (TextView) itemView.findViewById(R.id.item_harga_pemabayaran);
        }
    }

}

