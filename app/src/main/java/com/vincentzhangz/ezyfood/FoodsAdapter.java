package com.vincentzhangz.ezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vincentzhangz.ezyfood.models.Food;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Vector;


public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.FoodsViewHolder> {

    Vector<Food> foods;
    Context context;
    private OnFoodsListener onFoodsListener;

    public FoodsAdapter(Context context, Vector<Food> foods, OnFoodsListener onFoodsListener) {
        this.context = context;
        this.foods = foods;
        this.onFoodsListener = onFoodsListener;
    }


    @NonNull
    @Override
    public FoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.foods_item, parent, false);
        return new FoodsViewHolder(view, onFoodsListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodsViewHolder holder, int position) {
        holder.name.setText(foods.get(position).getName());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(0);
        formatter.setCurrency(Currency.getInstance("IDR"));
        holder.price.setText(formatter.format(foods.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public interface OnFoodsListener {
        void onClick(int position);
    }

    public class FoodsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, price;
        OnFoodsListener onFoodsListener;

        public FoodsViewHolder(@NonNull View itemView, OnFoodsListener onFoodsListener) {
            super(itemView);
            name = itemView.findViewById(R.id.food_name);
            price = itemView.findViewById(R.id.food_price);
            itemView.setOnClickListener(this);
            this.onFoodsListener = onFoodsListener;
        }

        @Override
        public void onClick(View v) {
            onFoodsListener.onClick(getAdapterPosition());
        }
    }


}
