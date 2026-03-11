package com.example.barangaycomplaints;

import java.util.ArrayList;
import java.util.List;

public class StoreUser {
    private List<User> userList;
    private static StoreUser INTANCE;

    public StoreUser() {
        userList = new ArrayList<>();
    }

    public static StoreUser getInstance() {
        if (INTANCE == null) {
            INTANCE = new StoreUser();
        }
        return INTANCE;
    }
    //add
    //edit/update
    //delete
    //read

    public void addUser(User user) {
        userList.add(user);
    }

    //get all users
    public List<User> getUserList() {
        return userList;
    }

    public User getUserById(int userId) {
        for (User user : userList) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    public void updateUser(int position, User updatedUser) {
        if(position >= 0 && position < userList.size()) {
            userList.set(position, updatedUser);
        }
    }

    public void deleteUserByPosition(int position) {
        for(User user : userList) {
            if(user.getId() == position){
                userList.remove(user);
                break;
            }
        }
    }

    public void deleteUserByName(String name) {
        for (User user: userList){
            if(user.getUsername().equals(name) || user.getFirstname().equals(name) || user.getLastname().equals(name)){
                userList.remove(user);
                break;
            }
        }
    }

    public List<User> readUser() {
        return userList;
    }


}
