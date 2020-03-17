package com.example.androidtest.multisection;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.androidtest.databinding.TypeOneItemBinding;

public class TypeOneViewHolder extends RecyclerView.ViewHolder {

    TypeOneItemBinding mbinding;
    Context mContext;

    public TypeOneViewHolder(TypeOneItemBinding mbinding, Context context) {
        super(mbinding.getRoot());
        this.mbinding = mbinding;
        this.mContext = context;
    }

    public void bind(TypeModel model) {
        mbinding.setModel(model);
    }
}
