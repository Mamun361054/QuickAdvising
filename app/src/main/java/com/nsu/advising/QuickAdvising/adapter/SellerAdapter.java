package com.nsu.advising.QuickAdvising.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nsu.advising.QuickAdvising.modal.SellerBook;
import com.nsu.advising.advising.R;

import java.util.ArrayList;

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.SellerViewHolder>{

    ArrayList<SellerBook> arrayList = new ArrayList<>();

    public SellerAdapter(ArrayList<SellerBook> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public SellerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_list_layout,parent,false);
        SellerViewHolder sellerViewHolder = new SellerViewHolder(view);
        return sellerViewHolder;
    }

    @Override
    public void onBindViewHolder(SellerViewHolder holder, int position) {

        //holder.btnPhnNumber.setText(arrayList.get(position).getPhnNumber());
        holder.txtBookName.setText(arrayList.get(position).getBookName());
        holder.txtBookPrice.setText("Price : "+arrayList.get(position).getBookPrice()+" taka");
        holder.txtBookEdition.setText("Edition : "+arrayList.get(position).getBookEdition());
        holder.txtAuthor.setText("Writer : "+arrayList.get(position).getBookAuthor());
        holder.txtDate.setText(arrayList.get(position).getBookDate());
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
            btnPhnNumber = (Button)v.findViewById(R.id.btnButton);
        }
    }

}
