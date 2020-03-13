package com.example.androidtest.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.example.androidtest.R;

import java.util.List;

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder> {

    List<UserSimpleModel> mList;
    Context mContext;

    public DataItemAdapter(Context context, List<UserSimpleModel> mList) {
        this.mList = mList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public DataItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return DataItemAdapter.ViewHolder.create(LayoutInflater.from(mContext), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull DataItemAdapter.ViewHolder viewHolder, int i) {
        UserSimpleModel userModel = mList.get(i);
        viewHolder.bind(userModel);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ViewDataBinding mBinding;

        static ViewHolder create(LayoutInflater inflater, ViewGroup parent) {
            RecyclerItemBindBinding binding = DataBindingUtil.inflate(inflater, R.layout.recycler_item_bind, parent, false);
            return new ViewHolder(binding);
        }

        private ViewHolder(RecyclerItemBindBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        void bind(UserSimpleModel userModel) {
            mBinding.setVariable(BR.user, userModel);
            mBinding.executePendingBindings();
        }
    }
}
