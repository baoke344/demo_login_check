package com.example.demo_login_check;

public class UserClass {
    private String userName;
    private String userPassword;

    public UserClass(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public UserClass() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}