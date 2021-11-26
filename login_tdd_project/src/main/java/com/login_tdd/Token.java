package com.login_tdd;

public class Token implements GamePlay {
    String tokenInfo;
    String tokenId;
    String userName;

    public Token(String info, String tokenId, String userName) {
        this.tokenInfo = info;
        this.tokenId = tokenId;
        this.userName = userName;
    }

    public String getTokenInfo() {
        return tokenInfo;
    }

    public void setTokenInfo(String tokenInfo) {
        this.tokenInfo = tokenInfo;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String playGame() {
        return this.tokenInfo;
    }
}
