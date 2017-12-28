package com.example.rezzandre.surgaresep;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cipowela on 29/12/17.
 */

public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.Holder> {

    private Context c;
    private List<Resep> resepList;

    public ResepAdapter(Context c, List<Resep> resepList) {
        this.c = c;
        this.resepList = resepList;
    }

    @Override
    public ResepAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resep_item, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(ResepAdapter.Holder holder, int position) {
        final Resep resep = resepList.get(position);
        holder.judul.setText(resep.judul);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, DetailResepActivity.class);
                intent.putExtra("judul", resep.judul);
                intent.putExtra("bahan", resep.bahan);
                intent.putExtra("langkah", resep.langkah);
                intent.putExtra("penulis", resep.penulis);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resepList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        LinearLayout layout;
        TextView judul;
        public Holder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout_item);
            judul = itemView.findViewById(R.id.judul);
        }
    }
}
