package com.example.hydroguard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.hydroguard.R;
import com.example.hydroguard.model.Todolist;

import java.util.List;

public class TodolistAdapter extends ArrayAdapter<Todolist> {
    public TodolistAdapter(Context context, int resource, List<Todolist> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Todolist todolist =getItem(position);
        if(convertView==null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.layout_todolist,parent,false);
        }
        TextView txvId = (TextView) convertView.findViewById(R.id.id);
        TextView txvJudul = (TextView) convertView.findViewById(R.id.judul);
        TextView txvDeskripsi = (TextView) convertView.findViewById(R.id.deskripsi);
        txvId.setText(todolist.getIdtdl());
        txvJudul.setText(todolist.getJudul());
        txvDeskripsi.setText(todolist.getDeskripsi());

        ImageView btnEdit = (ImageView) convertView.findViewById(R.id.edit);
        ImageView btnDelete = (ImageView) convertView.findViewById(R.id.delete);

        return convertView;
    }


}
