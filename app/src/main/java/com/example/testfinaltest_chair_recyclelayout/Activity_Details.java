package com.example.testfinaltest_chair_recyclelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Activity_Details extends AppCompatActivity {

    private ImageView img;
    private TextView tvName;
    private TextView tvPrice;
    private TextView tvDetails;
    private TextView tvQua;
    private ImageButton btnAdd;
    private ImageButton btnMinus;
    private Button btn;
    private double tt;
    private int q;
    private Product p;
    private List<Product> listSelectedProduct;
    private  List<Integer> listQuan;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__details);
        img = findViewById(R.id.imgDetails);
        tvName = findViewById(R.id.tvNameDetails);
        tvPrice = findViewById(R.id.tvPriceDetails);
        tvDetails = findViewById(R.id.tvDetailsDetails);
        tvQua = findViewById(R.id.tvQualityDetails);
        btnAdd = findViewById(R.id.imgBtnAdd);
        btnMinus = findViewById(R.id.imgBtnMinus);
        btn = findViewById(R.id.btnAddCartDetails);
        /* gán đối tượng */
        intent = getIntent();
        bundle = intent.getBundleExtra("data");
        intent = new Intent(this, Activity_Cart.class);
        p = new Product();
        listSelectedProduct = new ArrayList<>();
        listQuan = new ArrayList<>();
        p = bundle.getParcelable("selectedProduct");
        listSelectedProduct = bundle.getParcelableArrayList("listSelectedProduct");
        listQuan = bundle.getIntegerArrayList("listQuality");
        tvName.setText(p.getName());
        tvDetails.setText(p.getDetails());
        img.setImageResource(p.getImg());

        /*hàm định dạng tiền*/
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
        dfs.setDecimalSeparator('.');
        dfs.setGroupingSeparator(',');
        DecimalFormat df = new DecimalFormat("$#.###", dfs);
        tvPrice.setText(df.format(p.getPrice()));

        /*set sự kiện*/
        q = 1;
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q++;
                tvQua.setText(String.valueOf(q));

                ((TextView)findViewById(R.id.tvPriceDetails)).setText(df.format( p.getPrice()*q));
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                q--;
                tvQua.setText(String.valueOf(q));
                ((TextView)findViewById(R.id.tvPriceDetails)).setText(df.format( p.getPrice()*q));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listSelectedProduct.add(p);
                listQuan.add(q);
                bundle.putParcelableArrayList("listSelectedProduct", (ArrayList<Product>) listSelectedProduct);
                bundle.putIntegerArrayList("listQuality", (ArrayList<Integer>) listQuan);
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });

    }
}