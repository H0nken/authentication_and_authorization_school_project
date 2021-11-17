package com.login_tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Login {

    User activeUser;
    Boolean loginSuccess;
    List<User> validUsers = new ArrayList<>();

    public Login() {

        validUsers.add(new User("anna", "losen"));
        validUsers.add(new User("berit", "123456"));
        validUsers.add(new User("kalle", "password"));
    }

    /*
    public Boolean loginStart() {
        Scanner loginInput = new Scanner(System.in);

        System.out.println("Username: ");
        String userName = loginInput.nextLine();

        System.out.println("Password: ");
        String passWord = loginInput.nextLine();

        return loginCheck(userName, passWord);

    }
     */

    public Boolean loginCheck(String username, String password) {
        List<User> checkUser = validUsers.stream().filter(user -> user.getUserName().
                equals(username) && user.getPassword().equals(password)).
                collect(Collectors.toList());

        if (checkUser.size()>0) {
            return true;
        }else return false;

    }

    public List<User> getValidUsers() {
        return validUsers;
    }
}
