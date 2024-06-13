package com.example.kgrcet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

public class StudentListActivity extends AppCompatActivity {


    androidx.appcompat.widget.Toolbar mtoolbar;


    private ListView listView;
    private StudentListAdapter adapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);


        mtoolbar=findViewById(R.id.toolbar2);
        setSupportActionBar(mtoolbar);

        Drawable drawable= ContextCompat.getDrawable(getApplicationContext(),R.drawable.baseline_more_vert_24);
        mtoolbar.setOverflowIcon(drawable);


        String className = getIntent().getStringExtra("className");
        setTitle(className);

        listView = findViewById(R.id.list_view);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected doctor.
                Student selectedDoctor = studentList.get(position);

                // Create an intent to open the DoctorDetailsActivity.
                Intent intent = new Intent(StudentListActivity.this, StudentDetailActivity.class);
                Student student=adapter.getItem(position);
                intent.putExtra("doctor_image", selectedDoctor.getImageResourceId());
                intent.putExtra("doctor_name", selectedDoctor.getFullName());
                intent.putExtra("doctor_specialty", selectedDoctor.getRollNo());
                intent.putExtra("StudentName", student.getFullName() );
                startActivity(intent);
            }
        });


        studentList = new ArrayList<>();

        // Add students for the selected class
        if (className.equals("CSE")) {
            studentList.add(new Student(1, "Bharath Laddu", R.drawable.b, R.drawable.ni));
            studentList.add(new Student(2, "Naveen", R.drawable.n, R.drawable.a));
            studentList.add(new Student(3, "Vishwateja", R.drawable.v, R.drawable.bi));
        } else if (className.equals("ECE")) {
            studentList.add(new Student(1, "Venkatesh", R.drawable.ve, R.drawable.b));
            studentList.add(new Student(2, "Nithin", R.drawable.ni, R.drawable.n));

        } else if (className.equals("CSM")) {
            studentList.add(new Student(1, "Roman", R.drawable.r, R.drawable.ro));
            studentList.add(new Student(2, "Rocky", R.drawable.ro, R.drawable.r));

        } else if (className.equals("CSD")) {
            studentList.add(new Student(1, "Shiva", R.drawable.sh, R.drawable.i));
            studentList.add(new Student(2, "Ishan", R.drawable.i, R.drawable.ve));

        } else if (className.equals("MECH")) {
            studentList.add(new Student(1,"Indhu", R.drawable.a, R.drawable.n));
            studentList.add(new Student(2, "Bindhu", R.drawable.bi, R.drawable.v));
            studentList.add(new Student(3, "Sindhu", R.drawable.s, R.drawable.u));
        }

        adapter = new StudentListAdapter(this, studentList);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }
}