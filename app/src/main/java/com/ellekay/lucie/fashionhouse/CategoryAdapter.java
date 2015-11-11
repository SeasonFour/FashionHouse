package com.ellekay.lucie.fashionhouse;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

/**
 * Created by lucie on 11/4/15.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Categoryholder> {
    private Context context;
    private List<CategoryClass> itemList;

    public CategoryAdapter(Context context, List<CategoryClass> itemList){
        this.context = context;
        this.itemList = itemList;


    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class Categoryholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView card;
        ImageView img;
        TextView tv;
        public Categoryholder(View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.categorycard);
            img = (ImageView) itemView.findViewById(R.id.category_img);
            tv = (TextView) itemView.findViewById(R.id.category_text);
            card.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           // Toast.makeText(v.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
            int position = getAdapterPosition();
            Context context = itemView.getContext();
            if (position == 1){
            Intent i = new Intent(context, MakeUp.class);
            context.startActivity(i);
            }
        }
    }


    @Override
    public Categoryholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, null);
        Categoryholder catHolder = new Categoryholder(layoutView);
        return catHolder;
    }

    @Override
    public void onBindViewHolder(Categoryholder holder, int position) {
        holder.tv.setText(itemList.get(position).name);
        holder.img.setImageResource(itemList.get(position).image);

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }



}
