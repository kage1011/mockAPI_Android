package com.example.testfinaltest_chair_recyclelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Activity_Cart extends AppCompatActivity {

    private Recycle_Adapter_Cart adt;
    private RecyclerView rec;
    private Bundle bundle;
    private Intent intent;

    private List<Product> listProduct;
    private List<Integer> listQuality;
    private double tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__cart);

        rec = findViewById(R.id.recCart);
        intent = getIntent();
        bundle = intent.getBundleExtra("data");
        intent = new Intent(this, Activity_RecycleView1.class);
        listQuality = bundle.getIntegerArrayList("listQuality");
        listProduct = bundle.getParcelableArrayList("listSelectedProduct");
        /*khai báo adapter*/
        adt = new Recycle_Adapter_Cart(listProduct, this, listQuality);
        rec.setAdapter(adt);
        rec.setLayoutManager(new LinearLayoutManager(this));

        tt = 0;
        int k =0;
        for (Integer i : listQuality){
            tt += listProduct.get(k).getPrice()*i;
            k++;
        }
        /*hàm định dạng tiền*/
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
        dfs.setDecimalSeparator('.');
        dfs.setGroupingSeparator(',');
        DecimalFormat df = new DecimalFormat("$#.###", dfs);
        ((TextView)findViewById(R.id.tvTt)).setText(df.format(tt));
        ((TextView)findViewById(R.id.tvSub)).setText(df.format(tt));


        /*quay về màn hình chính */
        Button btn = findViewById(R.id.btnCheck);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
    }
}