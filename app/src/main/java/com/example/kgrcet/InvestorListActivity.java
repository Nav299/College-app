package com.example.kgrcet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class InvestorListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investor_list);

        List<Investor> investors = getSampleInvestors();

        // Creating adapter for the list
        InvestorListAdapter adapter = new InvestorListAdapter(this, investors);

        // Getting ListView reference
        ListView investorListView = findViewById(R.id.investorListView);

        // Setting adapter to ListView
        investorListView.setAdapter(adapter);
    }

    private List<Investor> getSampleInvestors() {
        // Replace this with your actual data retrieval logic
        List<Investor> investors = new ArrayList<>();

        // Add sample investors
        investors.add(new Investor("Naveen Roman", R.drawable.n));
        investors.add(new Investor("Indhu", R.drawable.a));
        investors.add(new Investor("Vishwateja", R.drawable.v));

        return investors;
    }
}