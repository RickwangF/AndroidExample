package com.example.androidtest.multisection;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.androidtest.databinding.TypeOneItemBinding;
import com.example.androidtest.databinding.TypeTwoItemBinding;

import java.util.List;

public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<TypeModel> mList;
    Context mContext;

    public MultiTypeAdapter() {
    }

    public MultiTypeAdapter(List<TypeModel> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    public void setList(List<TypeModel> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == 1) {
            TypeOneItemBinding bindingOne = TypeOneItemBinding.inflate(LayoutInflater.from(mContext), viewGroup, false);
            return new TypeOneViewHolder(bindingOne, mContext);
        } else {
            TypeTwoItemBinding bindingTwo = TypeTwoItemBinding.inflate(LayoutInflater.from(mContext), viewGroup, false);
            return new TypeTwoViewHolder(bindingTwo, mContext);
        }
    }

    @Override
    public int getItemViewType(int position) {
        TypeModel model = mList.get(position);
        return  model.typeId.get();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        TypeModel model = mList.get(position);
        if (viewHolder instanceof TypeOneViewHolder) {
            TypeOneViewHolder viewHolderOne = (TypeOneViewHolder)viewHolder;
            viewHolderOne.bind(model);
        } else {
            TypeTwoViewHolder viewHolderTwo = (TypeTwoViewHolder)viewHolder;
            viewHolderTwo.bind(model);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
