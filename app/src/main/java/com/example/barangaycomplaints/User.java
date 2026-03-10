package com.example.barangaycomplaints;

public class User {
    private int userId;
    private String lastname;
    private String firstname;
    private String address;
    private String username;
    private String password;
    private String email;

    private String phone;

    public User(
            String email,
            String password,
            String username,
            String address,
            String firstname,
            String lastname,
            String phone,
            int userId
    ) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.address = address;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userId = userId;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getId() {
        return userId;
    }


}
