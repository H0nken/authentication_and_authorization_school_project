package com.login_tdd;

public class Token {
    String tokenInfo;

    public Token(String info) {
        this.tokenInfo = info;
    }

    public String getTokenInfo() {
        return tokenInfo;
    }

    public void setTokenInfo(String tokenInfo) {
        this.tokenInfo = tokenInfo;
    }
}
