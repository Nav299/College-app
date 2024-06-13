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

public class LabAdapter  extends ArrayAdapter<Lab> {

    public LabAdapter(Context context, List<Lab> labs) {
        super(context, 0, labs);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lab, parent, false);
        }

        // Get the lab at the current position.
        Lab lab = getItem(position);

        // Set the lab data in the views.
        ImageView labImageView = convertView.findViewById(R.id.labImageView);
        TextView labNameTextView = convertView.findViewById(R.id.labNameTextView);

        if (lab != null) {
            labImageView.setImageResource(lab.getImageResId());
            labNameTextView.setText(lab.getName());
        }

        return convertView;
    }
}
