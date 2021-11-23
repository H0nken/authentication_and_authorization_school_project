package com.login_tdd;

public class User {

    String userName;
    String password;
    String token;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    public String getToken() {
        if (this.token!=null){
            return token;
        }else return null;

    }

    public void setToken(String token) {
        this.token = token;
    }

}
