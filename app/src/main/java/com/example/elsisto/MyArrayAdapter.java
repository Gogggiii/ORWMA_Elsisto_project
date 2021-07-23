package com.example.elsisto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import static com.example.elsisto.R.array.all_colors;

public class MyArrayAdapter extends ArrayAdapter<Name_and_Color> {
    private List<Name_and_Color> storage;
    private Context context;

    //LayoutInflater inflater;
    public MyArrayAdapter(@NonNull Context context, int resurceID, List<Name_and_Color> data) {
        super(context, resurceID, data);
        storage=new ArrayList<>();
        storage=data;
        Log.i("mytag", storage.get(3).getName());
        //inflater = LayoutInflater.from(context);
    }


    public View getCustomView(int position, View convertView, ViewGroup parent) {

        //LayoutInflater inflaterr=(LayoutInflater) context.getSystemService(  Context.LAYOUT_INFLATER_SERVICE );
        //View row = inflaterr.inflate(R.layout.custom_spinner_item, parent, false);
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_spinner_item, parent, false);
        TextView tv_name = (TextView) row.findViewById(R.id.tvColor);
        tv_name.setText(storage.get(position).getName());

        tv_name.setTextColor(Color.rgb(75, 180, 225));
        ImageView img = (ImageView) row.findViewById(R.id.imgColor);
        img.setImageResource(storage.get(position).getColor());
        Log.i("mytag","unutra"+position);
        if (position == 0) {
            //img.setVisibility(View.GONE);
            //tvLanguage.setTextSize(20f);
        }
        return row;
    }

    // It gets a View that displays in the drop down popup the data at the specified position
    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // It gets a View that displays the data at the specified position
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

}
