package com.login_tdd;

public class User implements Access {

    String userName;
    String password;
    String resource;
    String[] rights;

    public User(String userName, String password, String resource, String[] rights) {
        this.userName = userName;
        this.password = password;
        this.resource = resource;
        this.rights = rights;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String resource() {
        return this.resource;
    }

    @Override
    public String[] rights() {
        return this.rights;
    }
}
