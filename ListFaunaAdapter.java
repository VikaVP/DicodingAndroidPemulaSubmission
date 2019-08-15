package com.example.appsvikavp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListFaunaAdapter extends RecyclerView.Adapter<ListFaunaAdapter.ListViewHolder> {

    private ArrayList<Fauna> listFauna;

    public ListFaunaAdapter(ArrayList<Fauna> list){
        this.listFauna = list;
    }



    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_fauna, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int i) {
        final Fauna fauna = listFauna.get(i);

        Glide.with(holder.itemView.getContext())
                .load(fauna.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(fauna.getName());
        holder.tvDesc.setText(fauna.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(DetailActivity.IMG_FAUNA, fauna.getPhoto());
                Intent moveWithDataIntent = new Intent(v.getContext(), DetailActivity.class);
                moveWithDataIntent.putExtra(DetailActivity.NAME_FAUNA, fauna.getName());
                moveWithDataIntent.putExtras(bundle);
                moveWithDataIntent.putExtra(DetailActivity.DESC_FAUNA, fauna.getDescription());
                v.getContext().startActivity(moveWithDataIntent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return listFauna.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDesc = itemView.findViewById(R.id.tv_item_desc);

        }
    }

}
