package com.login_tdd;

public class Game {

    public Boolean playGame (String token) {
        if (token.length()!=36) {
           return false;
        }return true;

    }


}
