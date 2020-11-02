package com.vincentzhangz.ezyfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vincentzhangz.ezyfood.models.Product;

import java.text.NumberFormat;
import java.util.Currency;

public class MyOrderActivity extends AppCompatActivity {
    RecyclerView myOrderRecyclerView;
    public static TextView noOrder;
    public static LinearLayout payLayout;
    Button payNowButton;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        myOrderRecyclerView = findViewById(R.id.my_order_recycler_view);
        noOrder = findViewById(R.id.no_order);
        payNowButton = findViewById(R.id.pay_now_button);
        total = findViewById(R.id.total_price_order_list);
        payLayout = findViewById(R.id.pay_layout);

        MyOrderAdapter adapter = new MyOrderAdapter(this, MainActivity.myOrder);
        myOrderRecyclerView.setAdapter(adapter);
        myOrderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        payNowButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), PayActivity.class);
            startActivity(intent);
            finish();
        });


        if (MainActivity.myOrder.size() == 0) {
            noOrder.setVisibility(View.VISIBLE);
            payLayout.setVisibility(View.GONE);
        } else {
            noOrder.setVisibility(View.GONE);
            payLayout.setVisibility(View.VISIBLE);
            Integer t = 0;
            for (Product p :
                    MainActivity.myOrder) {
                t += p.getPrice() * p.getQuantity();
            }

            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            formatter.setMaximumFractionDigits(0);
            formatter.setCurrency(Currency.getInstance("IDR"));
            total.setText(String.format("Total: %s", formatter.format(t)));
        }
    }
}