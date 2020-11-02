package com.vincentzhangz.ezyfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vincentzhangz.ezyfood.models.Drink;
import com.vincentzhangz.ezyfood.models.Product;

import java.text.NumberFormat;
import java.util.Currency;

public class OrderDetail extends AppCompatActivity {
    TextView name, price;
    EditText quantity;
    Button addButton, orderMoreButton, myOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        name = findViewById(R.id.item_detail_name);
        price = findViewById(R.id.item_detail_price);
        quantity = findViewById(R.id.item_detail_quantity);
        addButton = findViewById(R.id.item_detail_add_button);
        orderMoreButton = findViewById(R.id.item_detail_order_more_button);
        myOrderButton = findViewById(R.id.item_detail_my_order_button);

        Intent intent = getIntent();
        Drink drink = (Drink) intent.getSerializableExtra("drink");

        name.setText(drink.getName());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(0);
        formatter.setCurrency(Currency.getInstance("IDR"));
        price.setText(formatter.format(drink.getPrice()));

        addButton.setOnClickListener(v -> {
            if (quantity.getText().toString().equals("")) {
                Toast.makeText(this, "Must input quantity", Toast.LENGTH_LONG).show();
            } else {
                int idx = -1;
                for (int i = 0; i < MainActivity.myOrder.size(); i++) {
                    if (MainActivity.myOrder.get(i).getName().equals(drink.getName())) {
                        idx = i;
                    }
                }

                if (idx == -1) {
                    Product p = drink;
                    p.setQuantity(Integer.parseInt(quantity.getText().toString()));
                    MainActivity.myOrder.add(p);
                } else {
                    MainActivity.myOrder.get(idx).setQuantity(MainActivity.myOrder.get(idx).getQuantity() + Integer.parseInt(quantity.getText().toString()));
                }
                Toast.makeText(this, "Successfully add drinks to order", Toast.LENGTH_LONG).show();
            }

        });

        orderMoreButton.setOnClickListener(v -> {
            Intent orderMoreIntent = new Intent(getApplicationContext(), DrinksActivity.class);
            startActivity(orderMoreIntent);
        });

        myOrderButton.setOnClickListener(v -> {
            Intent myOrderIntent = new Intent(getApplicationContext(), MyOrderActivity.class);
            startActivity(myOrderIntent);
        });
    }
}