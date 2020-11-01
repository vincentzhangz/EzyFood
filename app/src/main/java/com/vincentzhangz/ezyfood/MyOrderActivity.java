package com.vincentzhangz.ezyfood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyOrderActivity extends AppCompatActivity {
    RecyclerView myOrderRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        myOrderRecyclerView = findViewById(R.id.my_order_recycler_view);

        MyOrderAdapter adapter = new MyOrderAdapter(this, MainActivity.myOrder);
        myOrderRecyclerView.setAdapter(adapter);
        myOrderRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}