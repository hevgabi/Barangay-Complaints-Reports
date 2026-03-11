package com.example.barangaycomplaints;

import java.util.ArrayList;
import java.util.List;

public class StoreComplaint {
    private List<Complaint> complaintList;
    private static StoreComplaint INSTANCE;

    private StoreComplaint() {
        complaintList = new ArrayList<>();
    }

    public static StoreComplaint getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StoreComplaint();
        }
        return INSTANCE;
    }
    //add
    //edit/update
    //delete
    //read

    public void addComplaint(Complaint complaint) {
        complaintList.add(complaint);
    }

    //get all complaints
    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    //Description: Get a complaint by its ID.
    public Complaint getComplaintById(int complaintId) {
        for (Complaint complaint : complaintList) {
            if (complaint.getComplaintId() == complaintId) {
                return complaint;
            }
        }
        return null;
    }

    public void updateComplaint(int position, Complaint updatedComplaint) {
        if(position >= 0 && position < complaintList.size()) {
            complaintList.set(position, updatedComplaint);
        }
    }

    //delete complaintbyposition
    public void deleteComplaintByPosition(int position) {
        if (position >= 0 && position < complaintList.size()) {
            complaintList.remove(position);
        }
    }

    //delete complaintbyname
    public void deleteComplaintByName(String name) {
        for (Complaint complaint: complaintList) {
            if (complaint.getSubject().equals(name)) {
                complaintList.remove(complaint);
                break;
            }
        }
    }

    //readp
    public List<Complaint> readComplaint() {
        return complaintList;
    }
}
