package com.login_tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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

    public String loginCheck(String username, String password) throws LoginFail {

        List<User> checkUser = validUsers.stream().filter(user -> user.getUserName().
                equals(username) && user.getPassword().equals(password)).
                collect(Collectors.toList());

        if (checkUser.size() == 0) {
            throw new LoginFail("You are not a valid user");
        }
        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();
        return token;

    }


    public List<User> getValidUsers() {
        return validUsers;
    }
}
