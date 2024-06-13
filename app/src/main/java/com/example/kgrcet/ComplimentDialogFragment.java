package com.example.kgrcet;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class ComplimentDialogFragment  extends DialogFragment {

    public interface ComplimentDialogListener {
        void onComplimentSubmitted(String compliment);
    }

    private ComplimentDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_compliment,null);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final EditText complimentEditText = dialogView.findViewById(R.id.complimentEditText);

        builder.setView(dialogView)
                .setTitle("Write a Compliment")
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String compliment = complimentEditText.getText().toString().trim();
                        if (!compliment.isEmpty()) {
                            listener.onComplimentSubmitted(compliment);
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User canceled the dialog
                    }
                });

        return builder.create();
    }

    public void setListener(ComplimentDialogListener listener) {
        this.listener = listener;
    }
}
