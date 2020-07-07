package com.example.bigworkproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;

public class musicAdapter extends BaseAdapter {

    LinkedList<music> mData;
    private Context mContext;

    public musicAdapter(LinkedList<music> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
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
        convertView = LayoutInflater.from(mContext).inflate(R.layout.music,parent,false);
        TextView Mname = (TextView) convertView.findViewById(R.id.Mname);
        TextView Mauthor = (TextView) convertView.findViewById(R.id.Mauthor);
        Mname.setText(mData.get(position).getName());
        Mauthor.setText(mData.get(position).getAuthor());
        return convertView;
    }
}
