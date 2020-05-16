package com.onoh.ewallet02.activity.donasi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.onoh.ewallet02.R;
import com.onoh.ewallet02.model.Donasi;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecycleViewDonasiAdapter extends RecyclerView.Adapter<RecycleViewDonasiAdapter.DonasiViewHolder> {

    private ArrayList<Donasi> dataDonasi;

    public RecycleViewDonasiAdapter(ArrayList<Donasi> dataDonasi) {
        this.dataDonasi = dataDonasi;
    }

    @NotNull
    @Override
    public RecycleViewDonasiAdapter.DonasiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_donasi, parent, false);
        return new RecycleViewDonasiAdapter.DonasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewDonasiAdapter.DonasiViewHolder holder, int position) {
        holder.img.setImageResource(dataDonasi.get(position).getPhoto());
        holder.tv_nama_donasi.setText(dataDonasi.get(position).getNamaDonasi());
        holder.tv_tgl_donasi.setText(dataDonasi.get(position).getTanggalDonasi());
        holder.tv_dana_terkumpul.setText(dataDonasi.get(position).getNominalDonasi());
        holder.cv_donasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailDonasiActivity.class);
                mIntent.putExtra("namaDonasi", dataDonasi.get(position).getNamaDonasi());
                mIntent.putExtra("tanggalDonasi", dataDonasi.get(position).getTanggalDonasi());
                mIntent.putExtra("nominalDonasi", dataDonasi.get(position).getNominalDonasi());
                mIntent.putExtra("gambarDonasi",dataDonasi.get(position).getPhoto());
                view.getContext().startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (dataDonasi != null) ? dataDonasi.size() : 0;
    }

    public static class DonasiViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tv_nama_donasi, tv_tgl_donasi, tv_dana_terkumpul;
        private CardView cv_donasi;

        public DonasiViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_donasi);
            tv_nama_donasi = (TextView) itemView.findViewById(R.id.tv_nama_donasi);
            tv_tgl_donasi = (TextView) itemView.findViewById(R.id.tv_tgl_donasi);
            tv_dana_terkumpul = (TextView) itemView.findViewById(R.id.tv_dana_terkumpul);

            cv_donasi = (CardView) itemView.findViewById(R.id.cardViewDonasi);

        }
    }

}

