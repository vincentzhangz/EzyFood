package com.vincentzhangz.ezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vincentzhangz.ezyfood.models.Product;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Vector;

public class PayAdapter extends RecyclerView.Adapter<PayAdapter.PayViewHolder> {
    Vector<Product> myOrder;
    Context context;

    public PayAdapter(Context context, Vector<Product> products) {
        this.context = context;
        this.myOrder = products;
    }

    @NonNull
    @Override
    public PayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pay_item, parent, false);
        return new PayAdapter.PayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PayViewHolder holder, int position) {
        holder.name.setText(myOrder.get(position).getName());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(0);
        formatter.setCurrency(Currency.getInstance("IDR"));
        holder.price.setText(formatter.format(myOrder.get(position).getPrice()));
        holder.quantity.setText(myOrder.get(position).getQuantity().toString());
    }

    @Override
    public int getItemCount() {
        return myOrder.size();
    }

    public class PayViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, quantity;

        public PayViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name_pay);
            price = itemView.findViewById(R.id.product_price_pay);
            quantity = itemView.findViewById(R.id.product_quantity_pay);
        }
    }
}
