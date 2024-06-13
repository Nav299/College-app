package com.example.kgrcet;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class InvestorListAdapter extends ArrayAdapter<Investor> {

    public InvestorListAdapter(Context context, List<Investor> investors) {
        super(context, 0, investors);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Investor investor = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.investor_list_item, parent, false);
        }

        // Lookup view for data population
        ImageView investorImage = convertView.findViewById(R.id.investorImage);
        TextView investorName = convertView.findViewById(R.id.investorName);
        Button followButton = convertView.findViewById(R.id.followButton);

        // Populate the data into the template view using the data object
        if (investor != null) {
            investorImage.setImageResource(investor.getImageResource());
            investorName.setText(investor.getName());

            // You need to implement the follow button click logic here
            followButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle follow button click
                    // You might want to update the UI or perform some action here
                }
            });
        }

        // Return the completed view to render on screen
        return convertView;
    }

}
