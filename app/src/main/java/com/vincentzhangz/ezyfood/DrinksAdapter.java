package com.vincentzhangz.ezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vincentzhangz.ezyfood.models.Drink;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Vector;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder> {

    Vector<Drink> drinks;
    Context context;
    private OnDrinksListener onDrinksListener;

    public DrinksAdapter(Context context, Vector<Drink> drinks, OnDrinksListener onDrinksListener) {
        this.context = context;
        this.drinks = drinks;
        this.onDrinksListener = onDrinksListener;
    }


    @NonNull
    @Override
    public DrinksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.drinks_item, parent, false);
        return new DrinksViewHolder(view, onDrinksListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksViewHolder holder, int position) {
        holder.name.setText(drinks.get(position).getName());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(0);
        formatter.setCurrency(Currency.getInstance("IDR"));
        holder.price.setText(formatter.format(drinks.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public interface OnDrinksListener {
        void onClick(int position);
    }

    public class DrinksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, price;
        OnDrinksListener onDrinksListener;

        public DrinksViewHolder(@NonNull View itemView, OnDrinksListener onDrinksListener) {
            super(itemView);
            name = itemView.findViewById(R.id.drink_name);
            price = itemView.findViewById(R.id.drink_price);
            itemView.setOnClickListener(this);
            this.onDrinksListener = onDrinksListener;
        }

        @Override
        public void onClick(View v) {
            onDrinksListener.onClick(getAdapterPosition());
        }
    }


}
