package com.example.barangaycomplaints;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class StoreComplaint {

    private ComplaintDao complaintDao;
    private static StoreComplaint INSTANCE;

    private StoreComplaint(Context context) {
        AppDatabase db = AppDatabase.getINSTANCE(context);
        complaintDao = db.complaintDao();
    }

    public static StoreComplaint getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new StoreComplaint(context);
        }
        return INSTANCE;
    }
    //add
    //edit/update
    //delete
    //read

    public void addComplaint(Complaint complaint) {
        complaintDao.insert(complaint);
    }

    //get all complaints
    public List<Complaint> getComplaintList() {
        return complaintDao.getAllComplaintList();
    }

    //Description: Get a complaint by its ID.
    public Complaint getComplaintById(int complaintId) {
        if(complaintDao.getComplaintById(complaintId) != null) {
            return complaintDao.getComplaintById(complaintId);
        }
        return null;
    }

    //update the complaint
    public void updateComplaint(Complaint complaint) {
        complaintDao.update(complaint);
    }


    //delete complaintbyname
    public void deleteComplaintBySubject(String subject, Complaint complaint) {
        if(complaintDao.getComplaintBySubject(subject) != null) {
            complaintDao.delete(complaint);
        }
    }

}
