package com.example.taskfour;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context cxt;
    List<Abc> list;

    public Adapter(Context context, List<Abc> abc){
        cxt = context;
        list = abc;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(cxt).inflate(R.layout.recycler_view_downloads,viewGroup,false);
        Item item = new Item(view);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        TextView textView = viewHolder.itemView.findViewById(R.id.recyclerText);
        CircleImageView circleImageView = viewHolder.itemView.findViewById(R.id.recyclerImage);
        Picasso.get().load(list.get(i).getImageUrl()).placeholder(R.drawable.profile).fit().into(circleImageView);
        textView.setText(list.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Item extends RecyclerView.ViewHolder{

        public Item(@NonNull View itemView) {
            super(itemView);
        }
    }

}
