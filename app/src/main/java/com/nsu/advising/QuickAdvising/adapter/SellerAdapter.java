package com.nsu.advising.QuickAdvising.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nsu.advising.QuickAdvising.modal.SellerBook;
import com.nsu.advising.advising.R;

import java.util.ArrayList;

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.SellerViewHolder> {

    ArrayList<SellerBook> arrayList = new ArrayList<>();
    Context ctx;

    public SellerAdapter(ArrayList<SellerBook> arrayList, Context ctx) {
        this.arrayList = arrayList;
        this.ctx = ctx;
    }

    @Override
    public SellerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_list_layout, parent, false);
        SellerViewHolder sellerViewHolder = new SellerViewHolder(view);
        return sellerViewHolder;
    }

    @Override
    public void onBindViewHolder(SellerViewHolder holder, final int position) {

        holder.txtBookName.setText(arrayList.get(position).getBookName());
        holder.txtBookPrice.setText("Price : " + arrayList.get(position).getBookPrice() + " taka");
        holder.txtBookEdition.setText("Edition : " + arrayList.get(position).getBookEdition());
        holder.txtAuthor.setText("Writer : " + arrayList.get(position).getBookAuthor());
        holder.txtDate.setText(arrayList.get(position).getBookDate());

        holder.btnPhnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+Uri.encode(arrayList.get(position).getPhnNumber().toString().trim())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(callIntent);

                //Toast.makeText(ctx,arrayList.get(position).getPhnNumber().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class SellerViewHolder extends RecyclerView.ViewHolder{

        TextView txtBookName,txtBookEdition,txtBookPrice,txtAuthor,txtDate;
                Button btnPhnNumber;

        public SellerViewHolder(View v) {
            super(v);
            txtBookName = (TextView)v.findViewById(R.id.txtBookName);
            txtBookEdition = (TextView)v.findViewById(R.id.txtBookEdition);
            txtBookPrice = (TextView)v.findViewById(R.id.txtBookPrice);
            txtAuthor = (TextView)v.findViewById(R.id.txtAuthor);
            txtDate = (TextView)v.findViewById(R.id.txtDate);
            btnPhnNumber = (Button)v.findViewById(R.id.btnCallSeller);
        }
    }

}
