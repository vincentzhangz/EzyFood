package com.vincentzhangz.ezyfood;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vincentzhangz.ezyfood.models.Food;

import java.util.Vector;

public class FoodsActivity extends AppCompatActivity implements FoodsAdapter.OnFoodsListener {
    RecyclerView foodsRecyclerView;
    Vector<Food> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        foodsRecyclerView = findViewById(R.id.foods_recycler_view);

        foods = new Vector<>();
        initData();
        FoodsAdapter adapter = new FoodsAdapter(this, foods, this);
        foodsRecyclerView.setAdapter(adapter);
        foodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initData() {
        foods.add(new Food("Fried Rice", 10000));
        foods.add(new Food("Pempek", 15000));
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getApplicationContext(), OrderDetail.class);
        intent.putExtra("products", foods.get(position));
        startActivity(intent);
        finish();
    }
}