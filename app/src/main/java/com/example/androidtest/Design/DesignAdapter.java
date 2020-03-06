package com.example.androidtest.Design;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidtest.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DesignAdapter extends RecyclerView.Adapter<DesignAdapter.ViewHolder>{

    List<String> mList;

    DesignListItemClickListener mListener;

    public DesignAdapter(List<String> mList, DesignListItemClickListener mListener) {
        this.mList = mList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_function_item, viewGroup, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.designItemClicked(i);
            }
        });
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String functionName = mList.get(i);
        viewHolder.textView.setText(functionName);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.design_function_text)
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
