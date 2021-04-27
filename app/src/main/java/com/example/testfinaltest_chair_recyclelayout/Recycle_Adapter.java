package com.example.testfinaltest_chair_recyclelayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class Recycle_Adapter extends RecyclerView.Adapter<Recycle_Adapter.ViewHolder> {
    private List<Product> listProduct;
    private List<Integer> listQuality;

    private LayoutInflater inflater;
    private Context ctx;

    public Recycle_Adapter(List<Product> listProduct, Context ctx, List<Integer> listQuality) {
        this.listProduct = listProduct;
        inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.listQuality = listQuality;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recycle1, parent, false);
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
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView tvName;
        public final TextView tvPrice;
        public final ImageView img;
        public final ImageButton imgBtn;
        public final Recycle_Adapter adt;

        public ViewHolder(@NonNull View itemView, Recycle_Adapter adt) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.tvPrice = itemView.findViewById(R.id.tvPrice);
            this.img = itemView.findViewById(R.id.img);
            this.imgBtn = itemView.findViewById(R.id.btnAddCart);
            this.adt = adt;
            itemView.setOnClickListener(this);//đặt sự kiện cho view
        }

        /*nhấn vào intent là hình ảnh để xem detail */
        @Override
        public void onClick(View v) {
            Intent intent = ((Activity) ctx).getIntent();
            intent.getBundleExtra("data").putParcelable("selectedProduct", listProduct.get(getLayoutPosition()));
            Bundle bundle = intent.getBundleExtra("data");
            intent = new Intent(ctx, Activity_Details.class);
            intent.putExtra("data", bundle);
           ((Activity) ctx).startActivity(intent);
        }
    }
}
