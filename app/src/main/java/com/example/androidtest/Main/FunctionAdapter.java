package com.example.androidtest.Main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidtest.R;

import java.util.ArrayList;

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.ViewHolder>{

    ArrayList<FunctionModel> functionList;

    FunctionItemClickListener clickListener;

    public FunctionAdapter(ArrayList<FunctionModel> functionList, FunctionItemClickListener clickListener) {
        this.functionList = functionList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.function_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        FunctionModel model = functionList.get(i);
        viewHolder.textView.setText(model.functionName);
        final String className = functionList.get(i).className;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clickListener.itemClicked(className);
            }
        });
    }

    @Override
    public int getItemCount() {
        return functionList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.name_text);
        }
    }
}
