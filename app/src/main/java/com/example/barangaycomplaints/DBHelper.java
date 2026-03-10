package com.example.barangaycomplaints;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "barangay_complaints.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createComplaintTable =
                "CREATE TABLE tblComplaint (" +
                        "complaintId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "subject TEXT NOT NULL," +
                        "description TEXT NOT NULL," +
                        "date TEXT NOT NULL," +
                        "isResolved INTEGER NOT NULL," +
                        "FOREIGN KEY (userId) REFERENCES tblUser(userId))";
        String createUserTable =
                "CREATE TABLE tblUser (" +
                        "userId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "firstname TEXT NOT NULL," +
                        "lastname TEXT NOT NULL," +
                        "address TEXT NOT NULL," +
                        "username TEXT NOT NULL," +
                        "password TEXT NOT NULL," +
                        "email TEXT NOT NULL," +
                        "phone TEXT NOT NULL)";
        db.execSQL(createUserTable);
        db.execSQL(createComplaintTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tblComplaint");
        db.execSQL("DROP TABLE IF EXISTS tblUser");
        onCreate(db);
    }

    public


}
