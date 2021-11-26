package com.login_tdd;

import java.util.List;
import java.util.stream.Collectors;

public class AdvancedGame {
    Login login = new Login();
    List<User> users = login.getValidUsers();

    public AdvancedGame() {

    }

    public String[] playAdvancedGame(Token token, String resource) throws TokenFail, IndexOutOfBoundsException {


        if (token == null) {
            throw new TokenFail("Token are not valid");
        }

        try {
            List<User> usersWhitResourceList = users.stream().filter(user -> user.getUserName().
                    equals(token.userName) && user.resource.equals(resource)).
                    collect(Collectors.toList());
            if (usersWhitResourceList.size() == 0) {
                throw new TokenFail("Username in this Token are not valid");
            }
            return usersWhitResourceList.get(0).rights();

        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Resource index doesn't exist", e);
        }

    }
}
