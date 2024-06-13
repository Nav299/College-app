package com.example.kgrcet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClassListAdapter extends BaseAdapter {

    private Context context;
    private List<ClassItem> classItemList;

    public ClassListAdapter(Context context, List<ClassItem> classItemList) {
        this.context = context;
        this.classItemList = classItemList;
    }

    @Override
    public int getCount() {
        return classItemList.size();
    }

    @Override
    public ClassItem getItem(int position) {
        return classItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.class_list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.rollNoTextView);
        TextView textView1 = convertView.findViewById(R.id.fullNameTextView);

        ClassItem classItem = getItem(position);
        imageView.setImageResource(classItem.getImageResourceId());
        textView.setText(classItem.getClassName());

        return convertView;

    }
}
