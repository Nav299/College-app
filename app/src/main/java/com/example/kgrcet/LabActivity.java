package com.example.kgrcet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LabActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar mtoolbar;

    private ListView labsListView;
    private LabAdapter labAdapter;
    private List<Lab> labList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);


        // Initialize views.
        labsListView = findViewById(R.id.lab_list_view1);
        labsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lab selectedLab = labList.get(position);
                Intent intent=new Intent(LabActivity.this, LessonActivity.class);
                intent.putExtra("lab_name", selectedLab.getName());
                intent.putExtra("lab_image", selectedLab.getImageResId());
                startActivity(intent);
            }
        });

        // Retrieve data for labs for the selected doctor.
        Intent intent = getIntent();
        if (intent != null) {
            // You can use the doctor's data to fetch lab data for that doctor.
            labList = getLabsForDoctor(intent.getStringExtra("doctor_name"));
        }

        // Create a custom adapter and set it to the labsListView.
        labAdapter = new LabAdapter(this, labList);
        labsListView.setAdapter(labAdapter);
    }

    // Define a method to fetch lab data for the selected doctor.
    private List<Lab> getLabsForDoctor(String doctorName) {
        // Implement your logic to fetch lab data for the selected doctor here.
        // You can create a list of Lab objects with name and drawable resource IDs.
        // For now, let's assume you have a hardcoded list.
        List<Lab> labs = new ArrayList<>();
        if ("Indhu".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));






        } else if ("Naveen".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));
        } else if ("Bharath Laddu".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));
        } else if ("Vishwateja".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));
        } else if ("Venkatesh".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));

        } else if ("Nithin".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));
        } else if ("Roman".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));

        } else if ("Rocky".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));
        } else if ("Shiva".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));
        } else if ("Ishan".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));
        } else if ("Bindhu".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));

        } else if ("Sindhu".equals(doctorName)) {
            labs.add(new Lab("Physics Lab", R.drawable.phylab));
            labs.add(new Lab("English Lab", R.drawable.englishlab));
            labs.add(new Lab("Chemistry Lab", R.drawable.chemistrylab));
            labs.add(new Lab("Medical Lab", R.drawable.medicallab));
            labs.add(new Lab("Science Lab", R.drawable.sciencelab));
            labs.add(new Lab("Biology Lab", R.drawable.bilogylab));
            labs.add(new Lab("DS Lab", R.drawable.ds));
            labs.add(new Lab("DBMS Lab", R.drawable.dbms));
        }
        return labs;
    }

}