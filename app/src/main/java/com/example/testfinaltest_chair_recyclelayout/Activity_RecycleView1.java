package com.example.testfinaltest_chair_recyclelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Activity_RecycleView1 extends AppCompatActivity {

    private Recycle_Adapter adt;
    private RecyclerView rec;

    private List<Product> listProduct;
    private List<Integer> listQuality;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__recycle_view1);
        rec = findViewById(R.id.rec);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        listProduct = new ArrayList<>();
        listQuality = new ArrayList<>();
        listQuality = bundle.getIntegerArrayList("listQuality");
        listProduct = bundle.getParcelableArrayList("listProduct");
        adt = new Recycle_Adapter(listProduct, this, listQuality);
        rec.setAdapter(adt);//liên kết recycleview với adapter
        rec.setLayoutManager(new GridLayoutManager(this, 2));

    }
}