package com.vincentzhangz.ezyfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vincentzhangz.ezyfood.models.Product;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Vector;

public class PayActivity extends AppCompatActivity {
    RecyclerView payListRecyclerView;
    TextView total;
    Button backToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        payListRecyclerView = findViewById(R.id.pay_recycler_view);
        total = findViewById(R.id.total_price_pay_list);
        backToMenu = findViewById(R.id.back_to_menu);
        Vector<Product> data = (Vector<Product>) MainActivity.myOrder.clone();

        PayAdapter adapter = new PayAdapter(this, data);
        payListRecyclerView.setAdapter(adapter);
        payListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Integer t = 0;
        for (Product p :
                MainActivity.myOrder) {
            t += p.getPrice() * p.getQuantity();
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(0);
        formatter.setCurrency(Currency.getInstance("IDR"));
        total.setText(String.format("Total: %s", formatter.format(t)));

        backToMenu.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        MainActivity.myOrder.clear();
    }
}