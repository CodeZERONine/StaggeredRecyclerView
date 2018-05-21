package com.ebglobalventures.staggeredrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class StaggredRecyclerViewAdapter extends RecyclerView.Adapter<StaggredRecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> mImageURLs=new ArrayList<>();
    private ArrayList<String> mImageNames=new ArrayList<>();
    private Context mContext;

    public StaggredRecyclerViewAdapter(ArrayList<String> mImageURLs, ArrayList<String> mImageNames, Context mContext) {
        this.mImageURLs = mImageURLs;
        this.mImageNames = mImageNames;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewObject= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid_item,parent,false);
        ViewHolder vh=new ViewHolder(viewObject);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions requestOptions=new RequestOptions().placeholder(R.drawable.ic_launcher_foreground);

        Glide.with(mContext).load(mImageURLs.get(position)).apply(requestOptions).into(holder.imageURLs);
        holder.imageNames.setText(mImageNames.get(position));
        }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView imageURLs;
         TextView imageNames;


        public ViewHolder(View itemView) {
            super(itemView);
            this.imageURLs=itemView.findViewById(R.id.image_widget);
            this.imageNames=itemView.findViewById(R.id.text_widget);
        }
    }
}
