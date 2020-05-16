package com.onoh.ewallet02.activity.ukt;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.onoh.ewallet02.R;
import com.onoh.ewallet02.model.Universitas;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecycleViewUktAdapter extends RecyclerView.Adapter<RecycleViewUktAdapter.UktViewHolder> {

   private ArrayList<Universitas> dataUniversitas;

    public RecycleViewUktAdapter(ArrayList<Universitas> dataUniversitas) {
       this.dataUniversitas = dataUniversitas;
    }

    @NotNull
    @Override
    public RecycleViewUktAdapter.UktViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_universitas, parent, false);
        return new UktViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UktViewHolder holder, int position) {
        holder.img.setImageResource(dataUniversitas.get(position).getPhoto());
        holder.tv_nama_univ.setText(dataUniversitas.get(position).getNamaUniv());
        holder.cv_univ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), FormUktActivity.class);
                mIntent.putExtra("namaUniv", dataUniversitas.get(position).getNamaUniv());
                mIntent.putExtra("gambarUniv",dataUniversitas.get(position).getPhoto());
                view.getContext().startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (dataUniversitas != null) ? dataUniversitas.size() : 0;
    }

    public static class UktViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tv_nama_univ;
        private CardView cv_univ;

        public UktViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_universitas);
            tv_nama_univ = (TextView) itemView.findViewById(R.id.tv_nama_univ);
            cv_univ = (CardView) itemView.findViewById(R.id.cardViewUniversitas);

        }
    }

}
