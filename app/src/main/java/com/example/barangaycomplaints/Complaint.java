package com.example.barangaycomplaints;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblComplaint")
public class Complaint {
    @PrimaryKey(autoGenerate = true)
    private int complaintId;
    private String subject;
    private boolean isResolved;
    private String description;
    private int userId;
    private String imageUri; // Added for image support

    public Complaint(
            int complaintId,
            String description,
            boolean isResolved,
            String subject,
            int userId,
            String imageUri
    ) {
        this.complaintId = complaintId;
        this.description = description;
        this.isResolved = isResolved;
        this.subject = subject;
        this.userId = userId;
        this.imageUri = imageUri;
    }

    public int getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}