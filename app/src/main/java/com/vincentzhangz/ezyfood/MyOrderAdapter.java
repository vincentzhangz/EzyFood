package com.vincentzhangz.ezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vincentzhangz.ezyfood.models.Product;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Vector;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyOrderViewHolder> {

    Vector<Product> myOrder;
    Context context;

    public MyOrderAdapter(Context context, Vector<Product> products) {
        this.context = context;
        this.myOrder = products;
    }

    @NonNull
    @Override
    public MyOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_order_item, parent, false);
        return new MyOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderViewHolder holder, int position) {
        holder.name.setText(myOrder.get(position).getName());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(0);
        formatter.setCurrency(Currency.getInstance("IDR"));
        holder.price.setText(formatter.format(myOrder.get(position).getPrice()));
        holder.quantity.setText(myOrder.get(position).getQuantity().toString());
        holder.removeButton.setOnClickListener(v -> {
            MainActivity.myOrder.remove(position);
            notifyDataSetChanged();
            if (MainActivity.myOrder.size() == 0) {
                MyOrderActivity.noOrder.setVisibility(View.VISIBLE);
                MyOrderActivity.payLayout.setVisibility(View.GONE);
            } else {
                MyOrderActivity.noOrder.setVisibility(View.GONE);
                MyOrderActivity.payLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myOrder.size();
    }

    public class MyOrderViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, quantity;
        Button removeButton;

        public MyOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
            quantity = itemView.findViewById(R.id.product_quantity);
            removeButton = itemView.findViewById(R.id.remove_order);
        }
    }
}
