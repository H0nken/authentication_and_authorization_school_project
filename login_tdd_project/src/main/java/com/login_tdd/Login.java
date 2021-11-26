package com.login_tdd;

import javax.sql.rowset.spi.SyncResolver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Login {
    List<User> validUsers = new ArrayList<>();

    public Login() {
        validUsers.add(new User("anna", "losen", "ACCOUNT", new String[]{"READ"}));
        validUsers.add(new User("berit", "123456", "ACCOUNT", new String[]{"READ", "WRITE"}));
        validUsers.add(new User("kalle", "password", "PROVISION_CALC", new String[]{"EXECUTE"}));
    }

    public Token loginCheck(String username, String password) throws LoginFail {

        List<User> checkUser = validUsers.stream().filter(user -> user.getUserName().
                equals(username) && user.getPassword().equals(password)).
                collect(Collectors.toList());


        if (checkUser.size() == 0) {
            throw new LoginFail("You are not a valid user");
        }

        UUID uuid = UUID.randomUUID();
        String tokenId = uuid.toString();
        Token returnToken = new Token("Driving in a Ruf", tokenId, checkUser.get(0).userName);
        return returnToken;

    }

    public List<User> getValidUsers() {
        return validUsers;
    }
}
