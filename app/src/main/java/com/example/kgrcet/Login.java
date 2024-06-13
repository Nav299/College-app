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

public class Login extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar mtoolbar;

    private ListView listView;
    private ClassListAdapter adapter;
    private List<ClassItem> classItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mtoolbar=findViewById(R.id.toolbar1);
        setSupportActionBar(mtoolbar);

        Drawable drawable= ContextCompat.getDrawable(getApplicationContext(),R.drawable.baseline_more_vert_24);
        mtoolbar.setOverflowIcon(drawable);




        listView = findViewById(R.id.listView);
        classItemList = new ArrayList<>();
        classItemList.add(new ClassItem("CSE", R.drawable.cse));
        classItemList.add(new ClassItem("ECE", R.drawable.ece));
        classItemList.add(new ClassItem("CSM", R.drawable.csm));
        classItemList.add(new ClassItem("CSD", R.drawable.csd));
        classItemList.add(new ClassItem("MECH", R.drawable.m));
        adapter = new ClassListAdapter(this, classItemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassItem classItem = adapter.getItem(position);
                Intent intent = new Intent(Login.this, StudentListActivity.class);
                intent.putExtra("className", classItem.getClassName());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }
}