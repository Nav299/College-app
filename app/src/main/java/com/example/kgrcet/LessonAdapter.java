package com.example.kgrcet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LessonAdapter extends ArrayAdapter<LessonItem> {

    public LessonAdapter(Context context, List<LessonItem> lessons) {
        super(context, 0, lessons);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lesson, parent, false);
        }

        LessonItem lesson = getItem(position);

        if (lesson != null) {
            ImageView lessonImageView = convertView.findViewById(R.id.lessonImageView);
            TextView lessonNameTextView = convertView.findViewById(R.id.lessonNameTextView);

            lessonImageView.setImageResource(lesson.getImageResId());
            lessonNameTextView.setText(lesson.getName());
        }

        return convertView;
    }
}