package com.example.kgrcet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.IOException;
import java.io.InputStream;

public class PdfViewerActivity extends AppCompatActivity {

    private WebView pdfWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        // Initialize views.
        pdfWebView = findViewById(R.id.pdfWebView);

        // Retrieve the PDF file name from the intent.
        Intent intent = getIntent();
        if (intent != null) {
            String pdfFileName = intent.getStringExtra("pdf_file_name");
            loadPdf(pdfFileName);
        }
    }

    private void loadPdf(String pdfFileName) {
        // Assuming your PDF files are stored in the assets folder.
        try {
            // Read the PDF file as bytes from the assets folder.
            InputStream inputStream = getAssets().open(pdfFileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            // Convert the byte array to Base64.
            String encodedPdf = Base64.encodeToString(buffer, Base64.NO_WRAP);

            // Build the HTML content with the embedded PDF.
            String html = "<html><body><embed src=\"data:application/pdf;base64, " +
                    encodedPdf + "\" width=\"100%\" height=\"100%\" type='application/pdf'></body></html>";

            // Load the HTML content in the WebView.
            pdfWebView.loadData(html, "text/html", "base64");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}