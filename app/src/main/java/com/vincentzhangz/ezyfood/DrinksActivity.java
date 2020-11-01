package com.vincentzhangz.ezyfood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vincentzhangz.ezyfood.models.Drink;

import java.util.Vector;

public class DrinksActivity extends AppCompatActivity {
    RecyclerView drinksRecyclerView;
    Vector<Drink> drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        drinksRecyclerView = findViewById(R.id.drinks_recycler_view);

        drinks = new Vector<>();
        initData();
        DrinksAdapter adapter = new DrinksAdapter(this, drinks);
        drinksRecyclerView.setAdapter(adapter);
        drinksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void initData() {
        drinks.add(new Drink("Milk Tea", 10000));
        drinks.add(new Drink("Coffee", 15000));
    }
}