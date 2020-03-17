package com.example.androidtest.multisection;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.androidtest.databinding.TypeOneItemBinding;
import com.example.androidtest.databinding.TypeTwoItemBinding;

public class TypeTwoViewHolder extends RecyclerView.ViewHolder {

    TypeTwoItemBinding mbinding;
    Context mContext;

    public TypeTwoViewHolder(TypeTwoItemBinding mbinding, Context context) {
        super(mbinding.getRoot());
        this.mbinding = mbinding;
        this.mContext = context;
    }

    public void bind(TypeModel model) {
        mbinding.setModel(model);
        Glide.with(mContext).load(model.imageUrl.get()).into(mbinding.imgTwo);
    }
}
