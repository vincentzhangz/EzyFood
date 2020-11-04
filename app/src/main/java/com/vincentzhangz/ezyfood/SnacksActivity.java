package com.vincentzhangz.ezyfood;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vincentzhangz.ezyfood.models.Snack;

import java.util.Vector;

public class SnacksActivity extends AppCompatActivity implements SnacksAdapter.OnSnacksListener {
    RecyclerView snacksRecyclerView;
    Vector<Snack> snacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);
        snacksRecyclerView = findViewById(R.id.snacks_recycler_view);

        snacks = new Vector<>();
        initData();
        SnacksAdapter adapter = new SnacksAdapter(this, snacks, this);
        snacksRecyclerView.setAdapter(adapter);
        snacksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        snacks.add(new Snack("French Fries", 20000));
        snacks.add(new Snack("Potato Chips", 15000));
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getApplicationContext(), OrderDetail.class);
        intent.putExtra("products", snacks.get(position));
        startActivity(intent);
        finish();
    }
}