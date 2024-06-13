package com.example.kgrcet;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class UnitsAdapter extends ArrayAdapter<Units> {

    public UnitsAdapter(Context context, List<Units> labs) {
        super(context, 0, labs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lesson, parent, false);
        }

        // Get the lab at the current position.
        Units lab = getItem(position);

        // Set the lab data in the views.
        ImageView labImageView = convertView.findViewById(R.id.lessonImageView);
        TextView labNameTextView = convertView.findViewById(R.id.lessonNameTextView);

        if (lab != null) {
            labImageView.setImageResource(lab.getImageResId());
            labNameTextView.setText(lab.getName());
        }

        return convertView;
    }
}
