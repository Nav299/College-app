package com.example.kgrcet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LessonActivity extends AppCompatActivity {

    private ListView lessonsListView;
    private LessonAdapter lessonAdapter;
    private List<LessonItem> lessonList;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        ImageView LessonImageView=findViewById(R.id.LessonImageView);
        TextView LessonTextView=findViewById(R.id.LessonNameTextView);


        Intent labintent = getIntent();
        if (labintent != null){
            int LessonimageResId = labintent.getIntExtra("lab_image", R.drawable.n);
            String LessonName = labintent.getStringExtra("lab_name");

            LessonImageView.setImageResource(LessonimageResId);
            LessonTextView.setText(LessonName);
        }



        // Initialize views.
        lessonsListView = findViewById(R.id.lessonlist);

        Intent leintent=getIntent();
        if (leintent !=null){
            lessonList=getLessonsForLab(leintent.getStringExtra("lab_name"));
        }

        lessonsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected lesson.
                LessonItem selectedLessons = lessonList.get(position);

                // Create an intent to open the PdfViewActivity.
                openPdfActivity(selectedLessons.getPdfRawResourceId());
            }
        });

        // Retrieve data for lessons for the selected lab.


        // Create a custom adapter and set it to the lessonsListView.
        lessonAdapter = new LessonAdapter(this, lessonList);
        lessonsListView.setAdapter(lessonAdapter);
    }

    // Define a method to fetch lesson data for the selected lab.
    private List<LessonItem> getLessonsForLab(String labName) {
        // Implement your logic to fetch lesson data for the selected lab here.
        // You can create a list of Lesson objects with name and drawable resource IDs.
        // For now, let's assume you have a hardcoded list.
        List<LessonItem> lessons = new ArrayList<>();
        if ("Physics Lab".equals(labName)) {
            lessons.add(new LessonItem("Characters of Laser", R.drawable.laser, "Type A", "block_chain.pdf"));
            lessons.add(new LessonItem("Characters of Led", R.drawable.led, "Type B", "case_study.pdf"));
            lessons.add(new LessonItem("Losses of Optical fiber", R.drawable.optic, "Type c", "circular.pdf"));
            lessons.add(new LessonItem("Resonance in LCR circuit", R.drawable.rlc, "Type D", "coa_ass.pdf"));
            lessons.add(new LessonItem("Time Constant of RC circuit", R.drawable.rc, "Type E", "coi_ass.pdf"));
        }

        else if ("English Lab".equals(labName)) {



            lessons.add(new LessonItem("Physics Lab", R.drawable.phylab, "Type F", "course_structure.pdf"));
            lessons.add(new LessonItem("English Lab ", R.drawable.englishlab, "Type G", "edu_sumit.pdf"));
            lessons.add(new LessonItem("Chemistry Lab ", R.drawable.chemistrylab, "Type H", "grades.pdf"));
            lessons.add(new LessonItem("Medical Lab ", R.drawable.medicallab, "Type I", "online.pdf"));
            lessons.add(new LessonItem("Science Lab ", R.drawable.sciencelab, "Type J", "sid_red.pdf"));


        }
        else if ("Chemistry Lab".equals(labName)) {

            lessons.add(new LessonItem("Estimation of alkalinity in given water samples", R.drawable.alkaline, "Type K", "sid_red.pdf"));
            lessons.add(new LessonItem("Adsorption of acetic acid by charcoal", R.drawable.acetic, "Type L", "online.pdf"));
            lessons.add(new LessonItem("Potentiometric titration – acid-base/redox", R.drawable.titration, "Type M", "edu_sumit.pdf"));
            lessons.add(new LessonItem("Estimation of hardness by ion-exchange method", R.drawable.edta, "Type N", "circular.pdf"));
            lessons.add(new LessonItem("Determination of acid value of an oil", R.drawable.oil, "Type O", "online.pdf"));


        }

        else if ("Medical Lab".equals(labName)) {

            lessons.add(new LessonItem("Characters of Laser", R.drawable.laser, "Type A", "block_chain.pdf"));
            lessons.add(new LessonItem("Characters of Led", R.drawable.led, "Type B", "case_study.pdf"));
            lessons.add(new LessonItem("Losses of Optical fiber", R.drawable.optic, "Type c", "circular.pdf"));
            lessons.add(new LessonItem("Resonance in LCR circuit", R.drawable.rlc, "Type D", "coa_ass.pdf"));
            lessons.add(new LessonItem("Time Constant of RC circuit", R.drawable.rc, "Type E", "coi_ass.pdf"));

        }

        else if ("Science Lab".equals(labName)) {

            lessons.add(new LessonItem("Physics Lab", R.drawable.phylab, "Type F", "course_structure.pdf"));
            lessons.add(new LessonItem("English Lab ", R.drawable.englishlab, "Type G", "edu_sumit.pdf"));
            lessons.add(new LessonItem("Chemistry Lab ", R.drawable.chemistrylab, "Type H", "grades.pdf"));
            lessons.add(new LessonItem("Medical Lab ", R.drawable.medicallab, "Type I", "online.pdf"));
            lessons.add(new LessonItem("Science Lab ", R.drawable.sciencelab, "Type J", "sid_red.pdf"));



        }

        else if ("Biology Lab".equals(labName)) {

            lessons.add(new LessonItem("Characters of Laser", R.drawable.laser, "Type A", "block_chain.pdf"));
            lessons.add(new LessonItem("Characters of Led", R.drawable.led, "Type B", "case_study.pdf"));
            lessons.add(new LessonItem("Losses of Optical fiber", R.drawable.optic, "Type c", "circular.pdf"));
            lessons.add(new LessonItem("Resonance in LCR circuit", R.drawable.rlc, "Type D", "coa_ass.pdf"));
            lessons.add(new LessonItem("Time Constant of RC circuit", R.drawable.rc, "Type E", "coi_ass.pdf"));


        }

        else if ("DS Lab".equals(labName)) {

            lessons.add(new LessonItem("Estimation of alkalinity in given water samples", R.drawable.alkaline, "Type K", "sid_red.pdf"));
            lessons.add(new LessonItem("Adsorption of acetic acid by charcoal", R.drawable.acetic, "Type L", "online.pdf"));
            lessons.add(new LessonItem("Potentiometric titration – acid-base/redox", R.drawable.titration, "Type M", "edu_sumit.pdf"));
            lessons.add(new LessonItem("Estimation of hardness by ion-exchange method", R.drawable.edta, "Type N", "circular.pdf"));
            lessons.add(new LessonItem("Determination of acid value of an oil", R.drawable.oil, "Type O", "online.pdf"));


        }

        else if ("DBMS Lab".equals(labName)) {

            lessons.add(new LessonItem("Characters of Laser", R.drawable.laser, "Type A", "block_chain.pdf"));
            lessons.add(new LessonItem("Characters of Led", R.drawable.led, "Type B", "case_study.pdf"));
            lessons.add(new LessonItem("Losses of Optical fiber", R.drawable.optic, "Type c", "circular.pdf"));
            lessons.add(new LessonItem("Resonance in LCR circuit", R.drawable.rlc, "Type D", "coa_ass.pdf"));
            lessons.add(new LessonItem("Time Constant of RC circuit", R.drawable.rc, "Type E", "coi_ass.pdf"));

        }


        return lessons;





    }

    private void openPdfActivity(String pdfFileName){
        Intent typeintent=new Intent(LessonActivity.this, PdfViewerActivity.class);
        typeintent.putExtra("pdf_file_name", pdfFileName);
        startActivity(typeintent);
    }





}