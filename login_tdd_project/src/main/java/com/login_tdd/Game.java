package com.login_tdd;

public class Game {

    public void Game() {

    }
    public void startGame(Token token) {
        if (token.getTokenId().length()==36) {
            System.out.println(token.playGame());
        }
    }
}
