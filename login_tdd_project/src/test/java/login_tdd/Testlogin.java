package login_tdd;

import com.login_tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Testlogin {
    List<User> users = new ArrayList<>();
    User user = new User("testUser", "password", "ACCOUNT ", new String[]{"READ", "WRITE"});
    Login login = new Login();
    Token token = login.loginCheck("anna", "losen");
    Token token2 = login.loginCheck("berit", "123456");
    Game game = new Game();


    public Testlogin() throws LoginFail {
    }

    @BeforeEach
    void setUp() {
        users = login.getValidUsers();
    }

    @Test
    void create_user_success() {
        assertNotNull(user);
    }

    @Test
    void test_login_fail() {
        LoginFail loginFail =
                assertThrows(LoginFail.class, () -> login.loginCheck("Fail", users.get(0).getPassword()));

        assertEquals("You are not a valid user", loginFail.getMessage());
    }

    @Test
    void test_login_success() throws LoginFail {
        assertEquals(36, login.loginCheck("anna", "losen"));
        System.out.println(login.loginCheck("anna", "losen"));
    }

    @Test
    void test_bad_token() {
        assertEquals("Not valid", token);
    }

    @Test
    void test_good_token_id() {
        assertEquals(36, token.getTokenId().length());
    }

    @Test
    void test_game() {
        game.startGame(token);
    }

    @Test
    void test_game_access_in_token() {
        assertEquals("Driving in a Ruf", token.playGame());
    }

    @Test
    void test_advancedGame_not_null() {
        AdvancedGame advancedGame = new AdvancedGame();
        assertNotNull(advancedGame);
    }

    @Test
    void test_user_name_in_token() {
        assertEquals("anna", token.getUserName());
    }

    @Test
    void test_rights_in_user() {
        assertEquals(List.of("READ", "WRITE"), List.of(user.rights()));
    }

    @Test
    void test_advanced_game_success() throws TokenFail {
        AdvancedGame advancedGame = new AdvancedGame();

        String[] advancedGameReturn = advancedGame.playAdvancedGame(token2, users.get(1).resource());

        assertEquals(List.of("READ", "WRITE"), Arrays.asList(advancedGameReturn));
    }

    @Test
    void test_advanced_game_Username_fail() throws TokenFail {
        AdvancedGame advancedGame = new AdvancedGame();

        assertEquals(2, advancedGame.playAdvancedGame(token2, users.get(2).resource()).length);
    }


}













