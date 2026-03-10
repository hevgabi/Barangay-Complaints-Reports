package com.example.barangaycomplaints;

import android.content.Context;

public class Auth {
    private StoreUser storeUser;

    public Auth(Context context) {
        storeUser = StoreUser.getInstance(context);
    }

    //sign up user
    public boolean signup(User user) {
        User exitingUser = storeUser.getUserByUsername(user.getUsername());
        if (exitingUser != null) {
            return false;
        }
        storeUser.addUser(user);
        return true;
    }
    public User login(
            String username,
            String password
    ) {
        User user = storeUser.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }

    public boolean validateEmail(String email) {
        final String validEmailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}";

        if (!email.matches(validEmailPattern)) {
            return false;
        } else {
            return true;
        }
    }


}
