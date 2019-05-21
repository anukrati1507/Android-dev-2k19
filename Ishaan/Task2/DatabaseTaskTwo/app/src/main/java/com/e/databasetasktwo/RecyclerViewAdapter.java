package com.e.databasetasktwo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.databasetasktwo.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<String> item = new ArrayList<>();
    Context context;

    public RecyclerViewAdapter(ArrayList<String> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.individual_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.outputTextView.setText(item.get(i));

    }

    @Override
    public int getItemCount() {

        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ConstraintLayout constraintLayout;
        TextView outputTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
            outputTextView = itemView.findViewById(R.id.outputTextView);

        }
    }

}
