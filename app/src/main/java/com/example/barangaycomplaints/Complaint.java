package com.example.barangaycomplaints;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.time.LocalDate;

@Entity(tableName = "tblComplaint")
public class Complaint {
    @PrimaryKey(autoGenerate = true)
    private int complaintId;
    private String subject;
    private boolean isResolved;
    private String description;
    private int userId;

    public Complaint(
            int complaintId,
            String description,
            boolean isResolved,
            String subject,
            int userId
    ) {
        this.complaintId = complaintId;
        this.description = description;
        this.isResolved = isResolved;
        this.subject = subject;
        this.userId = userId;
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



}
