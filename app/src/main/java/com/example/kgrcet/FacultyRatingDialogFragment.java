package com.example.kgrcet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.List;

public class FacultyRatingDialogFragment extends DialogFragment {

    private static final String PREFS_NAME = "FacultyRatings";
    private static final String KEY_DATE_PREFIX = "Date_";

    private ListView facultyListView;
    private RatingBar ratingBar;

    private List<FacultyModel> facultyList;

    public FacultyRatingDialogFragment(List<FacultyModel> facultyList) {
        this.facultyList = facultyList;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_faculty_rating, null);

        facultyListView = dialogView.findViewById(R.id.facultyListView);
        ratingBar = dialogView.findViewById(R.id.ratingBar);

        // Create and set up the adapter for the ListView
        ArrayAdapter<FacultyModel> adapter = new FacultyAdapter(requireContext(), R.layout.faculty_list_item, facultyList);
        facultyListView.setAdapter(adapter);

        facultyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click, you can show more details or perform other actions
                // For now, let's just set the rating bar to 0 when a faculty is selected
                ratingBar.setRating(0);
            }
        });

        builder.setView(dialogView)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        float stars = ratingBar.getRating();
                        saveRatingToPrefs(stars);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        return builder.create();
    }

    private void saveRatingToPrefs(float stars) {
        Context context = requireContext();
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Use current date as the key to check if the user has already given stars for the day
        String currentDateKey = KEY_DATE_PREFIX + getCurrentDate();

        // Check if the user has already given stars for the day
        if (!prefs.getBoolean(currentDateKey, false)) {
            // Save stars to SharedPreferences
            SharedPreferences.Editor editor = prefs.edit();
            for (FacultyModel facultyItem : facultyList) {
                editor.putFloat(facultyItem.getName(), stars);
            }
            editor.putBoolean(currentDateKey, true);
            editor.apply();
        }
    }

    private String getCurrentDate() {
        // Implement getCurrentDate() method as before
        // ...
        return null;
    }
}
