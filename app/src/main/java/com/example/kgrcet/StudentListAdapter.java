package com.example.kgrcet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentListAdapter extends BaseAdapter {

    private Context context;
    private List<Student> studentList;

    public StudentListAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Student getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.student_list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView rollNoTextView = convertView.findViewById(R.id.rollNoTextView);
        TextView fullNameTextView = convertView.findViewById(R.id.fullNameTextView);

        Student student = studentList.get(position);

        imageView.setImageResource(student.getImageResourceId());
        rollNoTextView.setText(String.valueOf(student.getRollNo()));
        fullNameTextView.setText(student.getFullName());

        return convertView;
    }
}
