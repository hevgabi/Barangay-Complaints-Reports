package com.example.barangaycomplaints;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.barangaycomplaints.databinding.ActivityComplaintBinding;

public class ComplaintActivity extends AppCompatActivity {

    private ActivityComplaintBinding binding;
    
    // ADDED: Fields to track if we are editing or viewing an existing complaint
    private String mode = "ADD"; // Default mode is ADD
    private int position = -1;    // Position in the list if editing/viewing
    private Uri selectedImageUri; // Field to store the selected image URI

    // ADDED: ActivityResultLauncher for the new image selection feature
    private final ActivityResultLauncher<String> mGetContent = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            uri -> {
                if (uri != null) {
                    selectedImageUri = uri;
                    binding.ivPreview.setImageURI(uri); // Show preview of the selected image
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityComplaintBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // EDITED: Get data from intent to determine if we are in VIEW or EDIT mode
        if (getIntent().hasExtra("MODE")) {
            mode = getIntent().getStringExtra("MODE");
            position = getIntent().getIntExtra("POSITION", -1);
        }

        // ADDED: Initialize UI based on the mode (ADD, VIEW, or EDIT)
        setupUI();

        binding.btnBack.setOnClickListener(v -> finish());

        // ADDED: Listener for the image selection button
        binding.btnSelectImage.setOnClickListener(v -> mGetContent.launch("image/*"));

        // EDITED: Handle both Submit and Update in one button click
        binding.btnSubmit.setOnClickListener(v -> handleSave());
    }

    /**
     * ADDED: Method to configure the UI based on whether the user is 
     * filing a new complaint, viewing one, or editing an existing one.
     */
    private void setupUI() {
        if (position != -1) {
            // Retrieve existing complaint data
            Complaint complaint = StoreComplaint.getInstance().getComplaintList().get(position);
            binding.etSubject.setText(complaint.getSubject());
            binding.etDescription.setText(complaint.getDescription());
            
            // Handle existing image if present
            if (complaint.getImageUri() != null) {
                selectedImageUri = Uri.parse(complaint.getImageUri());
                binding.ivPreview.setImageURI(selectedImageUri);
            }

            if ("VIEW".equals(mode)) {
                // Configure UI for VIEW mode (Read-only)
                binding.tvTitle.setText("View Complaint");
                binding.etSubject.setEnabled(false);
                binding.etDescription.setEnabled(false);
                binding.btnSelectImage.setVisibility(View.GONE);
                binding.btnSubmit.setVisibility(View.GONE);
            } else if ("EDIT".equals(mode)) {
                // Configure UI for EDIT mode
                binding.tvTitle.setText("Edit Complaint");
                binding.btnSubmit.setText("UPDATE COMPLAINT");
            }
        } else {
            // Default UI for filing a NEW complaint
            binding.tvTitle.setText("File a Complaint");
            binding.btnSubmit.setText("SUBMIT COMPLAINT");
        }
    }

    /**
     * EDITED: Logic to either save a new complaint or update an existing one
     * based on the 'position' value.
     */
    private void handleSave() {
        String subject = binding.etSubject.getText().toString().trim();
        String description = binding.etDescription.getText().toString().trim();
        String imageUriStr = (selectedImageUri != null) ? selectedImageUri.toString() : null;

        if (subject.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (position == -1) {
            // FEATURE: Logic for creating a NEW Complaint
            int id = StoreComplaint.getInstance().getComplaintList().size() + 1;
            Complaint newComplaint = new Complaint(id, description, false, subject, 1, imageUriStr);
            StoreComplaint.getInstance().addComplaint(newComplaint);
            Toast.makeText(this, "Complaint submitted successfully", Toast.LENGTH_SHORT).show();
        } else {
            // FEATURE: Logic for UPDATING an existing Complaint
            Complaint existing = StoreComplaint.getInstance().getComplaintList().get(position);
            Complaint updated = new Complaint(
                    existing.getComplaintId(), 
                    description, 
                    existing.isResolved(), 
                    subject, 
                    existing.getUserId(), 
                    imageUriStr
            );
            StoreComplaint.getInstance().updateComplaint(position, updated);
            Toast.makeText(this, "Complaint updated successfully", Toast.LENGTH_SHORT).show();
        }

        finish(); // Close activity and return to list
    }
}