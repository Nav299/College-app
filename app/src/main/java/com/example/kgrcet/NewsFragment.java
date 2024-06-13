package com.example.kgrcet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment {


    private static final int GALLERY_REQUEST_CODE = 1;
    private static final long POST_DISPLAY_TIME=24*60*60*1000;
    private static final String PREFS_NAME="MyPrefsFile";
    private static final String POSTS_KEY ="posts";

    private List<post> posts= new ArrayList<>();
    private Handler handler = new Handler(Looper.getMainLooper());


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        // Post News Button Click
        Button postNewsButton = view.findViewById(R.id.postNewsButton);
        postNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle post news button click
                openGallery();
            }
        });

        // Floating "+" Symbol Click for Investor Activities
        ImageView investorActivitiesButton = view.findViewById(R.id.investorActivitiesButton);
        investorActivitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle navigation to Investor Activities
                Intent intent = new Intent(getActivity(), InvestorListActivity.class);
                startActivity(intent);

            }
        });

        return view;

    }
    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            // Handle image selection
            try {
                InputStream inputStream = requireContext().getContentResolver().openInputStream(data.getData());
                Bitmap selectedImage = BitmapFactory.decodeStream(inputStream);
                showPostDialog(selectedImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }





    private void displayPosts() {
        LinearLayout postsLayout = requireView().findViewById(R.id.postsLayout);
        postsLayout.removeAllViews();

        for (post post : posts) {
            View postView = getLayoutInflater().inflate(R.layout.post_item, postsLayout, false);

            // Set image and description
            ImageView postImageView = postView.findViewById(R.id.postImageView);
            TextView postDescriptionTextView = postView.findViewById(R.id.postDescriptionTextView);

            postImageView.setImageBitmap(post.getImage());
            postDescriptionTextView.setText(post.getDescription());

            // Set up share, download, and comment buttons (implement your logic)

            postsLayout.addView(postView);
        }

        // Schedule posts to be removed after 24 hours
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                removeExpiredPosts();
            }
        }, POST_DISPLAY_TIME);
    }

    private void removeExpiredPosts() {
        // Remove posts older than 24 hours
        long currentTime = System.currentTimeMillis();
        List<post> postsToRemove = new ArrayList<>();



        for (post post : posts) {
            if (currentTime - post.getTimestamp() >= POST_DISPLAY_TIME) {
                postsToRemove.add(post);
            }
        }

        posts.removeAll(postsToRemove);
        displayPosts(); // Update UI after removing expired posts
    }

    private void retrievePosts() {
        SharedPreferences prefs = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(POSTS_KEY, null);
        Type type = new TypeToken<ArrayList<post>>() {}.getType();
        posts = gson.fromJson(json, type);

        if (posts == null) {
            posts = new ArrayList<>();
        }
    }

    private void storePosts() {
        SharedPreferences prefs = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(posts);
        editor.putString(POSTS_KEY, json);
        editor.apply();
    }

    private void showPostDialog(Bitmap imageBitmap) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_post, null);

        // ... (Existing code)
        EditText descriptionEditText = dialogView.findViewById(R.id.descriptionEditText);

        builder.setView(dialogView);
        AlertDialog postDialog = builder.create();

        // Handle Submit button click in the dialog
        Button submitButton = dialogView.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = descriptionEditText.getText().toString().trim();

                if (!description.isEmpty()) {
                    long currentTimestamp = System.currentTimeMillis();
                    post post = new post(imageBitmap, description, currentTimestamp);
                    posts.add(post);
                    storePosts(); // Store updated posts to SharedPreferences
                    displayPosts();
                    postDialog.dismiss();
                } else {
                    // Show an error or prompt the user to enter a description
                    Toast.makeText(requireContext(), "Please enter a description", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Display the selected image in the dialog
        ImageView imageView = dialogView.findViewById(R.id.imageView);
        imageView.setImageBitmap(imageBitmap);

        postDialog.show();

    }
}