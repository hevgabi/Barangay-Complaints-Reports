package com.example.barangaycomplaints;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM tblUser")
    List<User> getAllUsers();

    @Query("SELECT * FROM tblUser WHERE userId = :userId")
    User getUserById(int userId);

    @Query("SELECT * FROM tblUser WHERE username = :username")
    User getUserByUsername(String username);

    @Query("SELECT * FROM tblUser WHERE email = :email")
    User getUserByEmail(String email);

    @Query("SELECT * FROM tblUser WHERE phone = :phone")
    User getUserByPhone(String phone);

}


