package com.example.androidtest.Design;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidtest.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DesignListAdapter extends BaseAdapter {

    private List<String> mList;
    private Context mContext;

    public DesignListAdapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.design_function_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String functionName = mList.get(position);
        holder.textView.setText(functionName);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.design_function_text)
        TextView textView;

        ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
