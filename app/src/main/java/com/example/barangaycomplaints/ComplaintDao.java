package com.example.barangaycomplaints;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ComplaintDao {
    @Insert
    void insert(Complaint complaint);

    @Update
    void update(Complaint complaint);
    @Delete
    void delete(Complaint complaint);

    @Query("SELECT * FROM tblComplaint")
    List<Complaint> getAllComplaintList();

    @Query("SELECT * FROM tblComplaint WHERE complaintId = :complaintId")
    Complaint getComplaintById(int complaintId);

    @Query("SELECT * FROM tblComplaint WHERE subject = :subject")
    Complaint getComplaintBySubject(String subject);





}
