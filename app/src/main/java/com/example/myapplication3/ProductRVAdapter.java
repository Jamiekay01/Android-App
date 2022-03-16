package com.example.myapplication3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductRVAdapter extends RecyclerView.Adapter<ProductRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<ProductModal> productModalArrayList;
    private Context context;

    // constructor
    public ProductRVAdapter(ArrayList<ProductModal> productModalArrayList, Context context) {
        this.productModalArrayList = productModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        ProductModal modal = productModalArrayList.get(position);
        holder.courseNameTV.setText(modal.getProductName());
        holder.courseDescTV.setText(modal.getProductCategory());
        holder.courseDurationTV.setText(modal.getBuyingPrice());
        holder.courseTracksTV.setText(modal.getSellingPrice());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return productModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView courseNameTV, courseDescTV, courseDurationTV, courseTracksTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            courseNameTV = itemView.findViewById(R.id.idTVProductName);
            courseDescTV = itemView.findViewById(R.id.idTVProductCategory);
            courseDurationTV = itemView.findViewById(R.id.idTVSellingPrice);
            courseTracksTV = itemView.findViewById(R.id.idTVBuyingPrice);
        }
    }
}

