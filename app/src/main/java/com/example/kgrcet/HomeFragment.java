package com.example.kgrcet;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    Button student, staff;

    private ListView listView;
    private ClassListAdapter adapter;
    private List<ClassItem> classItemList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button button1=view.findViewById(R.id.student_login_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLoginActivity();

            }
        });

        Button button2=view.findViewById(R.id.student_login_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLoginActivity();

            }
        });

        Button showRatingDialogButton = view.findViewById(R.id.showRatingDialogButton);
        showRatingDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFacultyListDialog();
            }
        });


        FloatingActionButton complimentFab = view.findViewById(R.id.complimentFab);
        complimentFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showComplimentDialog();
            }
        });


        // ... other initialization code

        return view;
    }

    private void navigateToLoginActivity(){
        Intent intent=new Intent(requireContext(), Login.class);
        startActivity(intent);
    }
    public void onClickbutton1(View view){
        navigateToLoginActivity();
    }
    public void onClickbutton2(View view){
        navigateToLoginActivity();
    }

    private void showFacultyListDialog(){
        List<FacultyModel> facultyList=generateSampleFacultyData();
        FacultyRatingDialogFragment dialogFragment= new FacultyRatingDialogFragment(facultyList);
        dialogFragment.show(getChildFragmentManager(), "FacultyRatingDialogFragment");
    }



    private List<FacultyModel> generateSampleFacultyData()
    {
        List<FacultyModel> facultyList = new ArrayList<>();
        facultyList.add(new FacultyModel("Naveen", R.drawable.n, "Coding"));
        facultyList.add(new FacultyModel("Bharath", R.drawable.b, "Physics"));
        facultyList.add(new FacultyModel("Ishan", R.drawable.i, "Model"));
        facultyList.add(new FacultyModel("Nithin", R.drawable.ni, "Sports"));
        facultyList.add(new FacultyModel("Roman", R.drawable.r, "WWE"));
        facultyList.add(new FacultyModel("Rocky", R.drawable.ro, "Acting"));
        return facultyList;

    }

    private void showComplimentDialog() {
        ComplimentDialogFragment dialogFragment = new ComplimentDialogFragment();
        dialogFragment.setListener(this::onComplimentSubmitted);
        dialogFragment.show(getChildFragmentManager(), "ComplimentDialogFragment");
    }



    public void onComplimentSubmitted(String compliment) {
        // Handle the submitted compliment (e.g., send to a server, store locally, etc.)
        // You can add your logic here
    }
}