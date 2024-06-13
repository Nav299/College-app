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

public class CertificatesActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar mtoolbar;

    private ListView certificatesListView;
    private CertificateAdapter certificateAdapter;
    private List<certificate> certificateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificates);


        mtoolbar=findViewById(R.id.toolbar4);
        setSupportActionBar(mtoolbar);

        Drawable drawable= ContextCompat.getDrawable(getApplicationContext(),R.drawable.baseline_more_vert_24);
        mtoolbar.setOverflowIcon(drawable);

        certificatesListView = findViewById(R.id.certificatesListView);

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
            certificates.add(new certificate("Certificate 1A", R.drawable.n));
            certificates.add(new certificate("Certificate 2A", R.drawable.v));
        } else if ("Naveen".equals(doctorName)) {
            certificates.add(new certificate("Certificate 1B", R.drawable.a));
            certificates.add(new certificate("Certificate 2B", R.drawable.bi));
        } else if ("Bharath Laddu".equals(doctorName)) {
            certificates.add(new certificate("Certificate 1C", R.drawable.ni));
            certificates.add(new certificate("Certificate 2C", R.drawable.v));
        } else if ("Vishwateja".equals(doctorName)) {
            certificates.add(new certificate("Certificate 1D", R.drawable.n));
            certificates.add(new certificate("Certificate 2D", R.drawable.a));
        } else if ("Venkatesh".equals(doctorName)) {
            certificates.add(new certificate("Certificate 1E", R.drawable.i));
            certificates.add(new certificate("Certificate 2E", R.drawable.s));

        } else if ("Nithin".equals(doctorName)) {
            certificates.add(new certificate("Certificate 1F", R.drawable.v));
            certificates.add(new certificate("Certificate 2F", R.drawable.ve));
            certificates.add(new certificate("Certificate 2F", R.drawable.i));
        } else if ("Roman".equals(doctorName)) {
            certificates.add(new certificate("Certificate 1G", R.drawable.n));
            certificates.add(new certificate("Certificate 2G", R.drawable.ro));

        } else if ("Rocky".equals(doctorName)) {
            certificates.add(new certificate("Certificate 1H", R.drawable.n));
            certificates.add(new certificate("Certificate 2H", R.drawable.r));
        } else if ("Shiva".equals(doctorName)) {
            certificates.add(new certificate("Certificate 1I", R.drawable.i));
        } else if ("Ishan".equals(doctorName)) {
            certificates.add(new certificate("Certificate 1J", R.drawable.sh));
            certificates.add(new certificate("Certificate 2J", R.drawable.ni));
        } else if ("Bindhu".equals(doctorName)) {
            certificates.add(new certificate("Certificate 1K", R.drawable.n));
            certificates.add(new certificate("Certificat 2K", R.drawable.a));
            certificates.add(new certificate("Certificate 3K", R.drawable.s));

        } else if ("Sindhu".equals(doctorName)) {
            certificates.add(new certificate("Certificate 1L", R.drawable.a));
            certificates.add(new certificate("Certificate 2L", R.drawable.n));
            certificates.add(new certificate("Certificate 3l", R.drawable.bi));
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