package com.example.barangaycomplaints;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class, Complaint.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract ComplaintDao complaintDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "Barangay_Complaint_database"
            )
                    .allowMainThreadQueries()
                    .build();
            return INSTANCE;
        } else {
            return INSTANCE;
        }

    }
}
