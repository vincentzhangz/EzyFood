package com.vincentzhangz.ezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vincentzhangz.ezyfood.models.Drink;
import com.vincentzhangz.ezyfood.models.Product;

import java.util.Vector;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder> {

    Vector<Drink> drinks;
    Context context;

    public DrinksAdapter(Context context, Vector<Drink> drinks) {
        this.context = context;
        this.drinks = drinks;
    }


    @NonNull
    @Override
    public DrinksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.drinks_item, parent, false);
        return new DrinksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksViewHolder holder, int position) {
        holder.name.setText(drinks.get(position).getName());
        holder.price.setText("Rp. " + drinks.get(position).getPrice());
        holder.add.setOnClickListener(v -> {
            int idx = -1;
            for (int i = 0; i < MainActivity.myOrder.size(); i++) {
                if (MainActivity.myOrder.get(i).getName().equals(drinks.get(position).getName())) {
                    idx = i;
                }
            }

            if (idx == -1) {
                Product p = drinks.get(position);
                p.setQuantity(1);
                MainActivity.myOrder.add(p);
            } else {
                MainActivity.myOrder.get(idx).setQuantity(MainActivity.myOrder.get(idx).getQuantity() + 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public class DrinksViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        Button add;

        public DrinksViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.drink_name);
            price = itemView.findViewById(R.id.drink_price);
            add = itemView.findViewById(R.id.drink_add_to_cart);
        }
    }
}
