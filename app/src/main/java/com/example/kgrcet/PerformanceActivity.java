package com.example.kgrcet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PerformanceActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar mtoolbar;

    private ListView certificatesListView;
    private CertificateAdapter certificateAdapter;
    private List<certificate> certificateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);


        mtoolbar=findViewById(R.id.toolbar6);
        setSupportActionBar(mtoolbar);

        Drawable drawable= ContextCompat.getDrawable(getApplicationContext(),R.drawable.baseline_more_vert_24);
        mtoolbar.setOverflowIcon(drawable);

        certificatesListView = findViewById(R.id.performanceListView);

        // Retrieve data for certificates for the selected doctor.
        Intent intent = getIntent();
        if (intent != null) {
            // You can use the doctor's data to fetch certificate data for that doctor.
            certificateList = getCertificatesForDoctor(intent.getStringExtra("doctor_name"));
        }

        // Create a custom adapter and set it to the certificatesListView.
        certificateAdapter = new CertificateAdapter(this, certificateList);
        certificatesListView.setAdapter(certificateAdapter);
    }

    // Define a method to fetch certificate data for the selected doctor.
    private List<certificate> getCertificatesForDoctor(String doctorName) {
        // Implement your logic to fetch certificate data for the selected doctor here.
        // You can create a list of Certificate objects with name and drawable resource IDs.
        // For now, let's assume you have a hardcoded list.
        List<certificate> certificates = new ArrayList<>();
        if ("Indhu".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.nineseven));
            certificates.add(new certificate("Manasa ", R.drawable.onezerozero));
        } else if ("Naveen".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.onezerozero));
            certificates.add(new certificate("Manasa", R.drawable.nineseven));
        } else if ("Bharath Laddu".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.zero));
            certificates.add(new certificate("Manasa", R.drawable.onesix));
        } else if ("Vishwateja".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.threesix));
            certificates.add(new certificate("Manasa", R.drawable.twothere));
        } else if ("Venkatesh".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.sevennine));
            certificates.add(new certificate("Manasa", R.drawable.sevenseven));

        } else if ("Nithin".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.eifhtthree));
            certificates.add(new certificate("Manasa", R.drawable.sevennine));
            certificates.add(new certificate("Raghu", R.drawable.sevensix));
        } else if ("Roman".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.fiveeight));
            certificates.add(new certificate("Manasa", R.drawable.fivefour));

        } else if ("Rocky".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.fournine));
            certificates.add(new certificate("Manasa", R.drawable.fourfive));
        } else if ("Shiva".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.onesix));
        } else if ("Ishan".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.sevenzero));
            certificates.add(new certificate("Manasa", R.drawable.sixnine));
        } else if ("Bindhu".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.sixfive));
            certificates.add(new certificate("Manasa", R.drawable.fiveeight));
            certificates.add(new certificate("Raghu", R.drawable.fournine ));

        } else if ("Sindhu".equals(doctorName)) {
            certificates.add(new certificate("Vaishnavi", R.drawable.a));
            certificates.add(new certificate("Manasa", R.drawable.n));
            certificates.add(new certificate("Raghu", R.drawable.bi));
        }
        return certificates;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }
}