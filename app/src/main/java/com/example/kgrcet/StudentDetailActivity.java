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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentDetailActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar mtoolbar;
    private String doctorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        doctorName=getIntent().getStringExtra("doctor_name");

        mtoolbar=findViewById(R.id.toolbar3);
        setSupportActionBar(mtoolbar);

        Drawable drawable= ContextCompat.getDrawable(getApplicationContext(),R.drawable.baseline_more_vert_24);
        mtoolbar.setOverflowIcon(drawable);

        ImageView doctorImageView = findViewById(R.id.doctorImageView);
        TextView doctorNameTextView = findViewById(R.id.doctorNameTextView);
        TextView doctorSpecialtyTextView = findViewById(R.id.doctorSpecialtyTextView);
        Button viewCertificatesButton = findViewById(R.id.viewCertificatesButton);
        viewCertificatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to open the CertificatesActivity.
                Intent intent = new Intent(StudentDetailActivity.this, CertificatesActivity.class);
                intent.putExtra("doctor_name", doctorName);
                startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button viewAttendenceButton = findViewById(R.id.viewAttendencesButton);
        viewAttendenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(StudentDetailActivity.this, AttendenceActivity.class);
                intent.putExtra("doctor_name", doctorName);
                startActivity(intent);
            }
        });

        Button viewperformance=findViewById(R.id.viewButton);
        viewperformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(StudentDetailActivity.this, PerformanceActivity.class);
                intent.putExtra("doctor_name", doctorName);
                startActivity(intent);

            }
        });

        Button viewgrade=findViewById(R.id.viewB);
        viewgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(StudentDetailActivity.this, GradeActivity.class);
                intent.putExtra("doctor_name", doctorName);
                startActivity(intent);

            }
        });



        Button viewLab=findViewById(R.id.viewlabsButton);
        viewLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent labintent=new Intent(StudentDetailActivity.this, LabActivity.class);
                labintent.putExtra("doctor_name", doctorName );
                startActivity(labintent);
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button viewlesson=findViewById(R.id.viewlessonButton);
        viewlesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent labintent=new Intent(StudentDetailActivity.this, UnitsActivity.class);
                labintent.putExtra("doctor_name", doctorName );
                startActivity(labintent);
            }
        });

        Button viewclub=findViewById(R.id.viewclubsButton);
        viewclub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clubintent= new Intent(StudentDetailActivity.this, ClubActivity.class);
                clubintent.putExtra("doctor_name", doctorName);
                startActivity(clubintent);
            }
        });
        // Retrieve doctor data from the intent.
        Intent intent = getIntent();
        if (intent != null) {
            int doctorImageResId = intent.getIntExtra("doctor_image", R.drawable.n);
            String doctorName = intent.getStringExtra("doctor_name");
            String doctorSpecialty = intent.getStringExtra("doctor_specialty");

            // Set doctor data in the views.
            doctorImageView.setImageResource(doctorImageResId);
            doctorNameTextView.setText(doctorName);
            doctorSpecialtyTextView.setText(doctorSpecialty);


        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;

    }
}