package com.vincentzhangz.ezyfood.utils;

import com.vincentzhangz.ezyfood.models.Product;

import java.util.Random;
import java.util.Vector;

public class Utility {
    public static void inflateData(Vector<Product> vector, Integer count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Product p = new Product(String.format("Product %03d", i + 1), (random.nextInt(5) + 1) * 10000);
            p.setQuantity(random.nextInt(100) + 1);
            vector.add(p);
        }
    }
}
