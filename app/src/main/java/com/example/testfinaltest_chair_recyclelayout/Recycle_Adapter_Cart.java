package com.example.testfinaltest_chair_recyclelayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Recycle_Adapter_Cart extends RecyclerView.Adapter<Recycle_Adapter_Cart.ViewHolder> {
    private List<Product> listProduct;
    private List<Integer> listQuality;

    private LayoutInflater inflater;
    private Context ctx;

    private double tt;

    public Recycle_Adapter_Cart(List<Product> listProduct, Context ctx, List<Integer> listQuality) {
        this.listProduct = listProduct;
        inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.listQuality = listQuality;

        tt = 0;
        int k =0;
        for (Integer i : listQuality){
            tt += listProduct.get(k).getPrice()*i;
            k++;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(listProduct.get(position).getName());
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
        dfs.setDecimalSeparator('.');
        dfs.setGroupingSeparator(',');
        DecimalFormat df = new DecimalFormat("$#.###", dfs);
        holder.tvPrice.setText(df.format(listProduct.get(position).getPrice()));
        holder.img.setImageResource(listProduct.get(position).getImg());
        holder.tvQuan.setText(String.valueOf(listQuality.get(position)));
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvName;
        public final TextView tvPrice;
        public final ImageView img;
        public final TextView tvQuan;
        public final Recycle_Adapter_Cart adt;
        public final ImageButton btnAdd;
        public final ImageButton btnMinus;

        public ViewHolder(@NonNull View itemView, Recycle_Adapter_Cart adt) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvNameCart);
            this.tvPrice = itemView.findViewById(R.id.tvPriceCart);
            this.img = itemView.findViewById(R.id.imgCart);
            this.adt = adt;
            this.tvQuan = itemView.findViewById(R.id.tvQuanCart);
            this.btnAdd = itemView.findViewById(R.id.imgBtnAdd2);
            this.btnMinus = itemView.findViewById(R.id.imgBtnMinus2);

            DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
            dfs.setDecimalSeparator('.');
            dfs.setGroupingSeparator(',');
            DecimalFormat df = new DecimalFormat("$#.###", dfs);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int q = Integer.parseInt(tvQuan.getText().toString());
                    q++;
                    tvQuan.setText(String.valueOf(q));
                    listQuality.set(getLayoutPosition(), q);

                    tt += listProduct.get(getLayoutPosition()).getPrice();
                    ((TextView)((Activity) ctx).findViewById(R.id.tvTt)).setText(df.format(tt));
                    ((TextView)((Activity) ctx).findViewById(R.id.tvSub)).setText(df.format(tt));
                    ((Activity) ctx).getIntent().getBundleExtra("data").putIntegerArrayList("listQuality", (ArrayList<Integer>) listQuality);
                }
            });
            btnMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int q = Integer.parseInt(tvQuan.getText().toString());
                    q--;
                    listQuality.set(getLayoutPosition(), q);
                    tvQuan.setText(String.valueOf(q));

                    tt -= listProduct.get(getLayoutPosition()).getPrice();
                    ((TextView)((Activity) ctx).findViewById(R.id.tvTt)).setText(df.format(tt));
                    ((TextView)((Activity) ctx).findViewById(R.id.tvSub)).setText(df.format(tt));
                    ((Activity) ctx).getIntent().getBundleExtra("data").putIntegerArrayList("listQuality", (ArrayList<Integer>) listQuality);
                }
            });


        }
    }
}
