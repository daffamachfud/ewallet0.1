package com.onoh.ewallet02.activity.event;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.onoh.ewallet02.R;
import com.onoh.ewallet02.model.Event;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecycleViewEventAdapter extends RecyclerView.Adapter<RecycleViewEventAdapter.EventViewHolder> {

private ArrayList<Event> dataEvent;

public RecycleViewEventAdapter(ArrayList<Event> dataEvent) {
        this.dataEvent = dataEvent;
        }

@NotNull
@Override
public RecycleViewEventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_event, parent, false);
        return new EventViewHolder(view);
        }

@Override
public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.img.setImageResource(dataEvent.get(position).getPhoto());
        holder.tv_nama_event.setText(dataEvent.get(position).getNamaEvent());
        holder.tv_tempat_event.setText(dataEvent.get(position).getNamaTempat());
        holder.tv_tgl_event.setText(dataEvent.get(position).getTanggalEvent());
        holder.cv_event.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Intent mIntent = new Intent(view.getContext(), DetailEventActivity.class);
        mIntent.putExtra("namaEvent", dataEvent.get(position).getNamaEvent());
        mIntent.putExtra("tempatEvent", dataEvent.get(position).getNamaTempat());
        mIntent.putExtra("tanggalEvent", dataEvent.get(position).getTanggalEvent());
        mIntent.putExtra("gambarEvent",dataEvent.get(position).getPhoto());
        view.getContext().startActivity(mIntent);
        }
        });

        }

@Override
public int getItemCount() {
        return (dataEvent != null) ? dataEvent.size() : 0;
        }

public static class EventViewHolder extends RecyclerView.ViewHolder{
    private ImageView img;
    private TextView tv_nama_event, tv_tgl_event, tv_tempat_event, tv_jenis_event;
    private CardView cv_event;

    public EventViewHolder(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.img_event);
        tv_nama_event = (TextView) itemView.findViewById(R.id.tv_nama_event);
        tv_tgl_event = (TextView) itemView.findViewById(R.id.tv_tgl_event);
        tv_tempat_event = (TextView) itemView.findViewById(R.id.tv_nama_tempat_event);

        cv_event = (CardView) itemView.findViewById(R.id.cardViewEvent);

    }
}

}
