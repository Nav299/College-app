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

public class ClubActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar mtoolbar;

    private ListView certificatesListView;
    private CertificateAdapter certificateAdapter;
    private List<certificate> certificateList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        mtoolbar=findViewById(R.id.toolbar10);
        setSupportActionBar(mtoolbar);

        Drawable drawable= ContextCompat.getDrawable(getApplicationContext(),R.drawable.baseline_more_vert_24);
        mtoolbar.setOverflowIcon(drawable);

        certificatesListView = findViewById(R.id.club_list_view);

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
            certificates.add(new certificate("Tech Club", R.drawable.techclub));
            certificates.add(new certificate("Singing Club ", R.drawable.singingclub));
            certificates.add(new certificate("Dancing Club ", R.drawable.danceclub));
        } else if ("Naveen".equals(doctorName)) {
            certificates.add(new certificate("3D printing Club", R.drawable.threedi));
            certificates.add(new certificate("Cinema Club", R.drawable.cinemaclub));
            certificates.add(new certificate("Public Speaking Club", R.drawable.publicspeaking));
        } else if ("Bharath Laddu".equals(doctorName)) {
            certificates.add(new certificate("Sports Club", R.drawable.sportsclub));
            certificates.add(new certificate("Web Design Club", R.drawable.webdesign));
            certificates.add(new certificate(" Block-Chain Club", R.drawable.blockchain));
        } else if ("Vishwateja".equals(doctorName)) {
            certificates.add(new certificate("Tech Club", R.drawable.techclub));
            certificates.add(new certificate("Singing Club ", R.drawable.singingclub));
            certificates.add(new certificate("Dancing Club ", R.drawable.danceclub));
        } else if ("Venkatesh".equals(doctorName)) {
            certificates.add(new certificate("3D printing Club", R.drawable.threedi));
            certificates.add(new certificate("Cinema Club", R.drawable.cinemaclub));
            certificates.add(new certificate("Public Speaking Club", R.drawable.publicspeaking));

        } else if ("Nithin".equals(doctorName)) {
            certificates.add(new certificate("Sports Club", R.drawable.sportsclub));
            certificates.add(new certificate("Web Design Club", R.drawable.webdesign));
            certificates.add(new certificate(" Block-Chain Club", R.drawable.blockchain));
        } else if ("Roman".equals(doctorName)) {
            certificates.add(new certificate("Tech Club", R.drawable.techclub));
            certificates.add(new certificate("Singing Club ", R.drawable.singingclub));
            certificates.add(new certificate("Dancing Club ", R.drawable.danceclub));

        } else if ("Rocky".equals(doctorName)) {
            certificates.add(new certificate("3D printing Club", R.drawable.threedi));
            certificates.add(new certificate("Cinema Club", R.drawable.cinemaclub));
            certificates.add(new certificate("Public Speaking Club", R.drawable.publicspeaking));
        } else if ("Shiva".equals(doctorName)) {
            certificates.add(new certificate("Sports Club", R.drawable.sportsclub));
            certificates.add(new certificate("Web Design Club", R.drawable.webdesign));
            certificates.add(new certificate(" Block-Chain Club", R.drawable.blockchain));
        } else if ("Ishan".equals(doctorName)) {
            certificates.add(new certificate("Tech Club", R.drawable.techclub));
            certificates.add(new certificate("Singing Club ", R.drawable.singingclub));
            certificates.add(new certificate("Dancing Club ", R.drawable.danceclub));

        } else if ("Bindhu".equals(doctorName)) {
            certificates.add(new certificate("3D printing Club", R.drawable.threedi));
            certificates.add(new certificate("Cinema Club", R.drawable.cinemaclub));
            certificates.add(new certificate("Public Speaking Club", R.drawable.publicspeaking));

        } else if ("Sindhu".equals(doctorName)) {
            certificates.add(new certificate("Sports Club", R.drawable.sportsclub));
            certificates.add(new certificate("Web Design Club", R.drawable.webdesign));
            certificates.add(new certificate(" Block-Chain Club", R.drawable.blockchain));
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