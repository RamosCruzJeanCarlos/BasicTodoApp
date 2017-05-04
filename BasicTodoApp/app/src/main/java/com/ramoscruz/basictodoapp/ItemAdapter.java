package com.ramoscruz.basictodoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jean Carlos Ramos Cruz on 04/05/17.
 */

public class ItemAdapter extends ArrayAdapter<String> {

    public ItemAdapter(Context context, ArrayList<String> list){
        super(context,0,list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String msg = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);
        }

        TextView tvItem = (TextView) convertView.findViewById(R.id.tvItem);
        tvItem.setText(msg);

        return convertView;
    }
}
