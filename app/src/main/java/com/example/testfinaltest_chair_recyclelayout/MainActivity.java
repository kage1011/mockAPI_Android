package com.example.testfinaltest_chair_recyclelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, Activity_RecycleView1.class);
        Bundle bundle = new Bundle();
        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images_2, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__2__1, 250));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__4__1, 150));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__5__1, 500));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images_2, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__2__1, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__4__1, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__5__1, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images_2, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__2__1, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__4__1, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__5__1, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images_2, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__2__1, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__4__1, 550));
        listProduct.add(new Product("Matteo Armchair", "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE", R.drawable.images__5__1, 550));

        bundle.putParcelableArrayList("listProduct", (ArrayList<Product>) listProduct);
        List<Integer> listQuality = new ArrayList<>();
        List<Product> listSelectedProduct = new ArrayList<>();
        Product p = new Product();
        bundle.putIntegerArrayList("listQuality", (ArrayList<Integer>) listQuality);
        bundle.putParcelable("selectedProduct", p);
        bundle.putParcelableArrayList("listSelectedProduct", (ArrayList<Product>) listSelectedProduct);
        intent.putExtra("data", bundle);
        startActivity(intent); //hiện view activity_recycle_view1.xml
    }
}