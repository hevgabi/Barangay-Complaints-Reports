package com.example.barangaycomplaints;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class StoreUser {
    private UserDao userDao;
    private static StoreUser INTANCE;

    public StoreUser(Context context) {
        AppDatabase db = AppDatabase.getINSTANCE(context);
        userDao = db.userDao();
    }

    public static StoreUser getInstance(Context context) {
        if (INTANCE == null) {
            INTANCE = new StoreUser(context);
        }
        return INTANCE;
    }
    //add
    //edit/update
    //delete
    //read

    public void addUser(User user) {
        userDao.insert(user);
    }

    //get all users
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    //get user by id
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    //update user
    public void updateUser(User user) {
        userDao.update(user);
    }

    //delete user
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    //read user(s)




}
