package com.vincentzhangz.ezyfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.vincentzhangz.ezyfood.models.Product;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    public static Vector<Product> myOrder = new Vector<>();
    Button myOrderButton, drinksButton, foodsButton, snacksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myOrderButton = findViewById(R.id.my_order_button);
        drinksButton = findViewById(R.id.drinks_button);
        foodsButton = findViewById(R.id.foods_button);
        snacksButton = findViewById(R.id.snacks_button);

//        Utility.inflateData(myOrder, 10);

        myOrderButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MyOrderActivity.class);
            startActivity(intent);
        });

        drinksButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), DrinksActivity.class);
            startActivity(intent);
        });

        foodsButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), FoodsActivity.class);
            startActivity(intent);
        });

        snacksButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SnacksActivity.class);
            startActivity(intent);
        });

    }


}