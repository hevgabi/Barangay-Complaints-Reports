package com.example.barangaycomplaints;

public class Complaint {
    private int complaintId;
    private String subject;
    private boolean isResolved;
    private String description;
    private String date;
    private User user;

    public Complaint(
            int complaintId,
            User user,
            String date,
            String description,
            boolean isResolved,
            String subject
    ) {
        this.complaintId = complaintId;
        this.user = user;
        this.date = date;
        this.description = description;
        this.isResolved = isResolved;
        this.subject = subject;
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

    public String getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }
}
