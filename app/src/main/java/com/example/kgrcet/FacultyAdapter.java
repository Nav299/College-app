package com.example.kgrcet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class FacultyAdapter extends ArrayAdapter<FacultyModel> {
    private Context context;
    private int resource;
    private List<FacultyModel> facultyList;

    public FacultyAdapter(Context context, int resource, List<FacultyModel> facultyList) {
        super(context, resource, facultyList);
        this.context = context;
        this.resource = resource;
        this.facultyList = facultyList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        FacultyModel facultyItem = facultyList.get(position);

        ImageView facultyImageView = convertView.findViewById(R.id.facultyImageView);
        TextView facultyNameTextView = convertView.findViewById(R.id.facultyNameTextView);
        TextView facultySubjectTextView = convertView.findViewById(R.id.facultySubjectTextView);
        RatingBar facultyratingBar= convertView.findViewById(R.id.facultyRatingBar);

        facultyImageView.setImageResource(facultyItem.getImageResId());
        facultyNameTextView.setText(facultyItem.getName());
        facultySubjectTextView.setText(facultyItem.getSubject());
        facultyratingBar.setRating(getSavedRating(facultyItem.getName()));

        return convertView;
    }

    private float getSavedRating(String facultyName){


        return 0;
    }

}
