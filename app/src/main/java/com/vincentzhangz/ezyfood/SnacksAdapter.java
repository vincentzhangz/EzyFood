package com.vincentzhangz.ezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vincentzhangz.ezyfood.models.Snack;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Vector;

public class SnacksAdapter extends RecyclerView.Adapter<SnacksAdapter.SnacksViewHolder> {

    Vector<Snack> snacks;
    Context context;
    private OnSnacksListener onSnacksListener;

    public SnacksAdapter(Context context, Vector<Snack> snacks, OnSnacksListener onSnacksListener) {
        this.context = context;
        this.snacks = snacks;
        this.onSnacksListener = onSnacksListener;
    }


    @NonNull
    @Override
    public SnacksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.snacks_item, parent, false);
        return new SnacksViewHolder(view, onSnacksListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SnacksViewHolder holder, int position) {
        holder.name.setText(snacks.get(position).getName());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(0);
        formatter.setCurrency(Currency.getInstance("IDR"));
        holder.price.setText(formatter.format(snacks.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return snacks.size();
    }

    public interface OnSnacksListener {
        void onClick(int position);
    }

    public class SnacksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, price;
        OnSnacksListener onSnacksListener;

        public SnacksViewHolder(@NonNull View itemView, OnSnacksListener onSnacksListener) {
            super(itemView);
            name = itemView.findViewById(R.id.snack_name);
            price = itemView.findViewById(R.id.snack_price);
            itemView.setOnClickListener(this);
            this.onSnacksListener = onSnacksListener;
        }

        @Override
        public void onClick(View v) {
            onSnacksListener.onClick(getAdapterPosition());
        }
    }


}
