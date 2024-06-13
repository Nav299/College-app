package com.example.kgrcet;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CertificateAdapter extends ArrayAdapter<certificate> {

public CertificateAdapter(Context context, List<certificate> Certificates) {
        super(context, 0, Certificates);
        }

@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_certificate, parent, false);
        }

        // Get the certificate at the current position.
        certificate Certificate = getItem(position);

        // Set the certificate data in the views.
        ImageView certificateImageView = convertView.findViewById(R.id.certificateImageView);
        TextView certificateNameTextView = convertView.findViewById(R.id.certificateNameTextView);

        if (Certificate != null) {
        certificateImageView.setImageResource(Certificate.getImageResId());
        certificateNameTextView.setText(Certificate.getName());
        }

        return convertView;
        }
}
