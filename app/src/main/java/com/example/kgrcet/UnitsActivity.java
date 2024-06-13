package com.example.kgrcet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UnitsActivity extends AppCompatActivity {

    private ListView lessonListView;
    private UnitsAdapter lessonAdapter;
    private List<Units> lessonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);


        lessonListView = findViewById(R.id.lab_list_view2);
        lessonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Units selectedLab = lessonList.get(position);
                Intent intent=new Intent(UnitsActivity.this, UnitLessonActivity.class);
                intent.putExtra("lab_name", selectedLab.getName());
                startActivity(intent);
            }
        });

        // Retrieve data for labs for the selected doctor.
        Intent intent = getIntent();
        if (intent != null) {
            // You can use the doctor's data to fetch lab data for that doctor.
            lessonList = getLabsForUnits(intent.getStringExtra("doctor_name"));
        }

        // Create a custom adapter and set it to the labsListView.
        lessonAdapter = new UnitsAdapter(this, lessonList);
        lessonListView.setAdapter(lessonAdapter);
    }

    // Define a method to fetch lab data for the selected doctor.
    private List<Units> getLabsForUnits(String doctorName) {
        // Implement your logic to fetch lab data for the selected doctor here.
        // You can create a list of Lab objects with name and drawable resource IDs.
        // For now, let's assume you have a hardcoded list.
        List<Units> labs = new ArrayList<>();
        if ("Indhu".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));






        } else if ("Naveen".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));
        } else if ("Bharath Laddu".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));
        } else if ("Vishwateja".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));
        } else if ("Venkatesh".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));

        } else if ("Nithin".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));
        } else if ("Roman".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));

        } else if ("Rocky".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));
        } else if ("Shiva".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));
        } else if ("Ishan".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));
        } else if ("Bindhu".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));

        } else if ("Sindhu".equals(doctorName)) {
            labs.add(new Units("Physics", R.drawable.physub));
            labs.add(new Units("DS", R.drawable.dssub));
            labs.add(new Units("Chemistry", R.drawable.chemistrysub));
            labs.add(new Units("Mathematics-1", R.drawable.m1));
            labs.add(new Units("COA", R.drawable.coa));
            labs.add(new Units("BEE", R.drawable.bee));
            labs.add(new Units("DAA", R.drawable.daasub));
            labs.add(new Units("DBMS", R.drawable.dbmssub));
        }
        return labs;
    }
}